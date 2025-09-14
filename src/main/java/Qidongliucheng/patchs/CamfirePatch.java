package Qidongliucheng.patchs;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.RoomTypeAssigner;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

import java.util.ArrayList;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.map;


public class CamfirePatch {
    @SpirePatch(clz = AbstractDungeon.class, method = "generateMap")
    public static class ModifyRewardScreenStuff {
        @SpireInsertPatch(
                loc=645
        )
        public static void patch() {

        }
    }
}
