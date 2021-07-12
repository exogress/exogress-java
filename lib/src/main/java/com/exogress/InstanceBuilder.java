package com.exogress;

import com.github.f4b6a3.ulid.Ulid;

import java.util.HashMap;

public final class InstanceBuilder {
    private Ulid accessKeyId;
    private String secretAccessKey;
    private String account;
    private String project;
    private String profile;
    private String configPath;
    private Boolean watchConfig = true;
    private HashMap<String, String> labels = new HashMap<String, String>();

    public InstanceBuilder(
            Ulid accessKeyId,
            String secretAccessKey,
            String account,
            String project
    ) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.account = account;
        this.project = project;
    }

    public InstanceBuilder profile(String profile) {
        this.profile = profile;
        return this;
    }

    public InstanceBuilder watchConfig(Boolean watchConfig) {
        this.watchConfig = watchConfig;
        return this;
    }

    public InstanceBuilder configPath(String configPath) {
        this.configPath = configPath;
        return this;
    }

    public InstanceBuilder label(String labelName, String labelValue) {
        this.labels.put(labelName, labelValue);
        return this;
    }

    public Instance build() throws Exception {
        return new com.exogress.Instance(
                this.accessKeyId.toString(),
                this.secretAccessKey,
                this.account,
                this.project,
                this.watchConfig
        );
    }
}