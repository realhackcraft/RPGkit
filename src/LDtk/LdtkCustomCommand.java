package LDtk;

import com.fasterxml.jackson.annotation.*;

public class LdtkCustomCommand {
    private String command;
    private When when;

    @JsonProperty("command")
    public String getCommand() { return command; }
    @JsonProperty("command")
    public void setCommand(String value) { this.command = value; }

    /**
     * Possible values: `Manual`, `AfterLoad`, `BeforeSave`, `AfterSave`
     */
    @JsonProperty("when")
    public When getWhen() { return when; }
    @JsonProperty("when")
    public void setWhen(When value) { this.when = value; }
}
