package com.myapp;

import com.myapp.utils.PhoneUtil;

import java.util.HashMap;

public class FormatNumber {

    public static void main(String[] args) {
        System.out.println(formatNumber2("+8617778115595"));
        System.out.println(formatNumber2("+8601010086"));
        System.out.println(formatNumber2("+12028710422"));
        System.out.println(formatNumber2("+1506"));
        HashMap<String,Object> map=new HashMap<>();
        map.put("ewjjl",333);
        map.put("jjlj","3322");
        map.put("jjjj",43l);
        System.out.println(map.toString());

    }

    /**
     * 第一种方案，参考手机通讯录格式化方式
     *
     * @param number
     * @return
     */
    public static String formatNumber2(String number) {
        String format = PhoneUtil.getCountryCode(number);//格式化号码
       return format;
    }

    /**
     * 第二种方案
     *
     * @param number
     * @return
     */
    public static String formatNumber(String number) {
        String format = PhoneUtil.format(number);//格式化号码
        if (!format.equals("")) {//规范号码直接输出
            return format;
        } else if (number != null) {
            char[] chars = number.toCharArray();
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < chars.length; i++) {
                switch (chars.length) {
                    case 1:
                    case 2:
                    case 3:
                        sb.append(chars[i]);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        if (i == 2) {
                            sb.append(chars[i]).append(" ");
                        } else {
                            sb.append(chars[i]);
                        }
                        break;
                    case 8:
                    case 9:
                    case 10:
                        if (i == 2 || i == 5) {
                            sb.append(chars[i]).append(" ");
                        } else {
                            sb.append(chars[i]);
                        }
                        break;
                    case 11:
                        if (i == 2 || i == 6) {
                            sb.append(chars[i]).append(" ");
                        } else {
                            sb.append(chars[i]);
                        }
                        break;
                    default:
                        sb.append(chars[i]);
                        break;

                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}
