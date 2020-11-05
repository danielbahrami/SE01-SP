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
        NPCList = new HashMap<String, NPC>();
    }

    public void addNPCs()
    {
        NPCList.put(name, new NPC(name, quest, getQuestItem()));
    }

    public String getQuest()
    {
        return quest;
    }

    public String getName()
    {
        return name;
    }

    public Item getQuestItem()
    {
        return questItem;
    }

    public void setQuestItem(Item item)
    {
        questItem = new Item(null,null);
    }
}
