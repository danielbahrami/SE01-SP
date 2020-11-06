package pandemic;

import java.util.HashMap;

public class NPC {

    private String name;
    private Item questItem;
    private String quest;
    private HashMap<String, NPC> NPCList;

    public NPC(String name, String quest, Item questItem)
    {
        this.name = name;
        this.quest = quest;
        this.questItem = questItem;
        this.NPCList = new HashMap<String, NPC>();
    }

    public void addNPCs()
    {
        this.NPCList.put(this.name, new NPC(this.name, this.quest, getQuestItem()));
    }

    public String getQuest()
    {
        return this.quest;
    }

    public String getName()
    {
        return this.name;
    }

    public Item getQuestItem()
    {
        return this.questItem;
    }

    public void setQuestItem(Item item)
    {
        this.questItem = new Item(null,null, null);
    }
}
