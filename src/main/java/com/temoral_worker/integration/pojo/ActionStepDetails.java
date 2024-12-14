package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActionStepDetails {
    @JsonProperty("action_type")
    private String actionType;

    @JsonProperty("smtp_settings")
    private SmtpSettings smtpSettings;

    @JsonProperty("email_template")
    private EmailTemplate emailTemplate;

    @JsonProperty("recipients")
    private List<String> recipients;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public SmtpSettings getSmtpSettings() {
        return smtpSettings;
    }

    public void setSmtpSettings(SmtpSettings smtpSettings) {
        this.smtpSettings = smtpSettings;
    }

    public EmailTemplate getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(EmailTemplate emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    // Getters and setters

    public static class SmtpSettings {
        @JsonProperty("server")
        private String server;

        @JsonProperty("port")
        private int port;

        @JsonProperty("authentication")
        private Authentication authentication;

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public Authentication getAuthentication() {
            return authentication;
        }

        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }

        // Getters and setters

        public static class Authentication {
            @JsonProperty("username")
            private String username;

            @JsonProperty("password")
            private String password;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            // Getters and setters
        }
    }

    public static class EmailTemplate {
        @JsonProperty("subject")
        private String subject;

        @JsonProperty("body")
        private String body;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        // Getters and setters
    }
}