package pandemic;

public class NPC {

    private String name;

    private String quest;

    public NPC(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void NPCTalk(String quest)
    {
        System.out.println("I need " + quest);
        this.quest = quest;
    }
    
    public String getQuest()
    {
        return quest;
    }
}
