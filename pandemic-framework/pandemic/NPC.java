package pandemic;

public class NPC {

    private String name;

    private String quest;

    public NPC(String name)
    {
        this.name = name;
        this.quest = getQuest;
        NPCTalk();
        isQuestDone();
    }

    public String getName()
    {
        return name;
    }

    public void NPCTalk(String quest)
    {
        System.out.println(getQuest());
        this.quest = quest;
    }
    
    public String getQuest()
    {
        return quest + questItem;
    }
    
    public String getQuestItem()
    {
        return questItem.toString();
    }
    
    public boolean isQuestDone()
    {
        boolean done = false;

        if (done)
        {
            getQuest();
            done = false;
        } else if (!done) {
            System.out.println("Quest complete!");
            done = true;
        }

        return false;
    }
}
