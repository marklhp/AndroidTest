package com.myapp.linphone.call;

/*
CallManager.java
Copyright (C) 2017  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

import org.linphone.core.Address;
import org.linphone.core.Call;
import org.linphone.core.CallParams;
import org.linphone.core.Core;
import org.linphone.core.CoreException;
import org.linphone.mediastream.Log;

/**
 * Handle call updating, reinvites.
 */
public class CallManager {
    private int currentProfile = HIGH_RESOLUTION;
    public static final int HIGH_RESOLUTION = 0;
    public static final int LOW_RESOLUTION = 1;
    public static final int LOW_BANDWIDTH = 2;
    private static CallManager instance;

    private CallManager() {
    }

    public static final synchronized CallManager getInstance() {
        if (instance == null) instance = new CallManager();
        return instance;
    }


    public void inviteAddress(Core lc,Address lAddress, boolean videoEnabled, boolean lowBandwidth) throws CoreException {

        CallParams params = lc.createCallParams(null);
        updateWithProfileSettings(lc, params);

        if (videoEnabled && params.videoEnabled()) {
            params.enableVideo(true);
        } else {
            params.enableVideo(false);
        }

        if (lowBandwidth) {
            params.enableLowBandwidth(true);
            Log.d("Low bandwidth enabled in call params");
        }
        String num=lAddress.asStringUriOnly();
        lc.inviteAddressWithParams(lAddress, params);
    }

    /**
     * Add video to a currently running voice only call.
     * No re-invite is sent if the current call is already video
     * or if the bandwidth settings are too low.
     *
     * @return if updateCall called
     */
    public boolean reinviteWithVideo(Core lc) {
        Call lCall = lc.getCurrentCall();
        if (lCall == null) {
            Log.e("Trying to reinviteWithVideo while not in call: doing nothing");
            return false;
        }
        CallParams params = lc.createCallParams(lCall);

        if (params.videoEnabled()) return false;


        // Check if video possible regarding bandwidth limitations
        updateWithProfileSettings(lc, params);

        // Abort if not enough bandwidth...
        if (!params.videoEnabled()) {
            return false;
        }

        // Not yet in video call: try to re-invite with video
        lc.updateCall(lCall, params);
        return true;
    }

    /**
     * Change the preferred video size used by linphone core. (impact landscape/portrait buffer).
     * Update current call, without reinvite.
     * The camera will be restarted when mediastreamer chain is recreated and setParameters is called.
     */
    public void updateCall(Core lc) {
        Call lCall = lc.getCurrentCall();
        if (lCall == null) {
            Log.e("Trying to updateCall while not in call: doing nothing");
            return;
        }
        CallParams params = lc.createCallParams(lCall);
        updateWithProfileSettings(lc, params);
        lc.updateCall(lCall, null);
    }
    public void updateWithProfileSettings(Core lc, CallParams callParams) {
        if (callParams != null) { // in call
            // Update video parm if
            if (!isVideoPossible()) { // NO VIDEO
                callParams.enableVideo(false);
                callParams.setAudioBandwidthLimit(40);
            } else {
                callParams.enableVideo(true);
                callParams.setAudioBandwidthLimit(0); // disable limitation
            }
        }
    }

    public boolean isVideoPossible() {
        return currentProfile != LOW_BANDWIDTH;
    }
}
