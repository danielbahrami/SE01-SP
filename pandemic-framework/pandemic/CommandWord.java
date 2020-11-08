package pandemic;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), TAKE("take"), USE("use"), GIVE("give"), INVENTORY("inventory"), UNLOCK("unlock"), TALK("talkto"), DROP("drop"), EAT ("eat"), EXAMINE("examine"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
