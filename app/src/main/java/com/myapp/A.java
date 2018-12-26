package com.myapp;

class A{
    String GrantType;
    B Data;

    public String getGrantType() {
        return GrantType;
    }

    public void setGrantType(String grantType) {
        GrantType = grantType;
    }

    public B getData() {
        return Data;
    }

    public void setData(B data) {
        Data = data;
    }
}
class B{
    String VerificationCode;
    String LoginName;
    String CountryCode;

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        VerificationCode = verificationCode;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
}
