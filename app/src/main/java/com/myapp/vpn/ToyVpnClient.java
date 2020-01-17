package com.myapp.vpn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.VpnService;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityVpnBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class ToyVpnClient extends BaseActivity<ActivityVpnBinding> implements View.OnClickListener {
    SharedPreferences prefs;

    public interface Prefs {
        String NAME = "connection";
        String SERVER_ADDRESS = "server.address";
        String SERVER_PORT = "server.port";
        String SHARED_SECRET = "shared.secret";
        String PROXY_HOSTNAME = "proxyhost";
        String PROXY_PORT = "proxyport";
        String ALLOW = "allow";
        String PACKAGES = "packages";
    }

    @Override
    protected void initView() {
        binding.setClick(this);

        prefs = getSharedPreferences(Prefs.NAME, MODE_PRIVATE);
        binding.address.setText(prefs.getString(Prefs.SERVER_ADDRESS, ""));
        int serverPortPrefValue = prefs.getInt(Prefs.SERVER_PORT, 0);
        binding.port.setText(String.valueOf(serverPortPrefValue == 0 ? "" : serverPortPrefValue));
        binding.secret.setText(prefs.getString(Prefs.SHARED_SECRET, ""));
        binding.proxyhost.setText(prefs.getString(Prefs.PROXY_HOSTNAME, ""));
        int proxyPortPrefValue = prefs.getInt(Prefs.PROXY_PORT, 0);
        binding.proxyport.setText(proxyPortPrefValue == 0 ? "" : String.valueOf(proxyPortPrefValue));


        binding.allowed.setChecked(prefs.getBoolean(Prefs.ALLOW, true));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.packages.setText(String.join(", ", prefs.getStringSet(
                    Prefs.PACKAGES, Collections.<String>emptySet())));
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_vpn;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.connect:
                if (!checkProxyConfigs(binding.proxyhost.getText().toString(),
                        binding.proxyport.getText().toString())) {
                    return;
                }
                Set<String> packageSet = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    packageSet = Arrays.stream(binding.packages.getText().toString().split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .collect(Collectors.toSet());
                }
                if (!checkPackages(packageSet)) {
                    return;
                }
                int serverPortNum;
                try {
                    serverPortNum = Integer.parseInt(binding.port.getText().toString());
                } catch (NumberFormatException e) {
                    serverPortNum = 0;
                }
                int proxyPortNum;
                try {
                    proxyPortNum = Integer.parseInt(binding.proxyport.getText().toString());
                } catch (NumberFormatException e) {
                    proxyPortNum = 0;
                }
                prefs.edit()
                        .putString(Prefs.SERVER_ADDRESS, binding.address.getText().toString())
                        .putInt(Prefs.SERVER_PORT, serverPortNum)
                        .putString(Prefs.SHARED_SECRET, binding.secret.getText().toString())
                        .putString(Prefs.PROXY_HOSTNAME, binding.proxyhost.getText().toString())
                        .putInt(Prefs.PROXY_PORT, proxyPortNum)
                        .putBoolean(Prefs.ALLOW, binding.allowed.isChecked())
                        .putStringSet(Prefs.PACKAGES, packageSet)
                        .commit();
                Intent intent = VpnService.prepare(ToyVpnClient.this);
                if (intent != null) {
                    startActivityForResult(intent, 0);
                } else {
                    onActivityResult(0, RESULT_OK, null);
                }
                break;
            case R.id.disconnect:
                startService(getServiceIntent().setAction(ToyVpnService.ACTION_DISCONNECT));
                break;
        }
    }
    private boolean checkProxyConfigs(String proxyHost, String proxyPort) {
        final boolean hasIncompleteProxyConfigs = proxyHost.isEmpty() != proxyPort.isEmpty();
        if (hasIncompleteProxyConfigs) {
            Toast.makeText(this, R.string.incomplete_proxy_settings, Toast.LENGTH_SHORT).show();
        }
        return !hasIncompleteProxyConfigs;
    }
    private boolean checkPackages(Set<String> packageNames) {
        boolean hasCorrectPackageNames = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            hasCorrectPackageNames = packageNames.isEmpty() ||
                    getPackageManager().getInstalledPackages(0).stream()
                            .map(pi -> pi.packageName)
                            .collect(Collectors.toSet())
                            .containsAll(packageNames);
        }
        if (!hasCorrectPackageNames) {
            Toast.makeText(this, R.string.unknown_package_names, Toast.LENGTH_SHORT).show();
        }
        return hasCorrectPackageNames;
    }
    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if (result == RESULT_OK) {
            startService(getServiceIntent().setAction(ToyVpnService.ACTION_CONNECT));
        }
    }
    private Intent getServiceIntent() {
        return new Intent(this, ToyVpnService.class);
    }
}
