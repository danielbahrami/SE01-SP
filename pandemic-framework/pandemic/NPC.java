package pandemic;

public class NPC {

    private String name;
    private Item questItem;
    private String quest;

    public NPC(String name)
    {
        this.name = name;
        this.quest = getQuest();
        NPCTalk();
        isQuestDone();
    }

    public String getName()
    {
        return name;
    }

    public void NPCTalk()
    {
        System.out.println(getQuest());

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
