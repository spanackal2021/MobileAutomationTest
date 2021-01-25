package com.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;

import static com.utils.UtilConstants.*;


public class AppiumSeverUtils {

    static AppiumDriverLocalService server;

    public static void Start(){
        if(isPortAvailable(Integer.parseInt(getPort()))){
            getInstance().start();
            System.out.println("Server started from here!");
        }else
            System.out.println("Server already running!");
    }

    static AppiumDriverLocalService getInstance(){
        if(server == null){
            setInstance();
            server.clearOutPutStreams(); //stop printing appium logs to console
        }
        return server;
    }

    static void setInstance(){
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(Integer.parseInt(getPort()))
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("AppiumLog.txt"));

        server = AppiumDriverLocalService.buildService(builder);
    }

    public static boolean isPortAvailable(int port) {
        //applicable for tcp ports
        try (ServerSocket serverSocket = new ServerSocket()) {
            // setReuseAddress(false) is required only on OSX,
            // otherwise the code will not work correctly on that platform
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public static void Stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped!");
        }
    }

}
