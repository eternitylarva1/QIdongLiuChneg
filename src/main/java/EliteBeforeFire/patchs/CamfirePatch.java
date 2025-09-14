package EliteBeforeFire.patchs;


import EliteBeforeFire.utils.Invoker;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.RoomTypeAssigner;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import com.megacrit.cardcrawl.ui.campfire.RestOption;
import com.megacrit.cardcrawl.ui.campfire.SmithOption;

import java.util.ArrayList;

import static EliteBeforeFire.modcore.eliteBeforeFire.firemap;
import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.map;


public class CamfirePatch {
    @SpirePatch(clz = AbstractDungeon.class, method = "generateMap")
    public static class ModifyRewardScreenStuff {
        @SpireInsertPatch(
                loc=645
        )
        public static void patch() {
            RoomTypeAssigner.assignRowAsRoomType((ArrayList)map.get(map.size() - 1), MonsterRoomElite.class);
        }
    }
}
