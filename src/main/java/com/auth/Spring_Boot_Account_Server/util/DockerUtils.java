package com.auth.Spring_Boot_Account_Server.util;

public class DockerUtils {

    private static final String DOCKER_ENV_VAR = "IS_DOCKER";

    // Method to check if the app is running inside a Docker container
    public static Boolean isDockerRunning() {
        return "true".equalsIgnoreCase(System.getenv(DOCKER_ENV_VAR));
    }
}
