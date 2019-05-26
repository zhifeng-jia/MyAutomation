package common.configuration;

import common.constans.HostInfoConstant;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    private static Map<String, String> loginInfo;

    private ConfigReader() {}

    public static Map<String, String> getLogionInfo() throws IOException {
        if (loginInfo != null) {
            return loginInfo;
        }

        loginInfo = new HashMap<String, String>();
        File file = new File("loginInfo.txt");
        if (!file.exists() || file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = null;
        StringBuffer sb = new StringBuffer();
        temp = br.readLine();
        int i = 0;
        while (temp != null ) {
            switch (i) {
                case 0:
                    loginInfo.put(HostInfoConstant.USER_NAME,temp);
                    break;
                case 1:
                    loginInfo.put(HostInfoConstant.PASSWORD, temp);
                    break;
                case 2:
                    loginInfo.put(HostInfoConstant.CLIENT_ID, temp);
                    break;
                case 3:
                    loginInfo.put(HostInfoConstant.CLIENT_SECURITY, temp);
                    break;
            }
            temp = br.readLine();
            i++;
        }
        br.close();
        return  loginInfo;
    }
}
