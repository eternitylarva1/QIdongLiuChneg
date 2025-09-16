//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Qidongliucheng.relics;

import Qidongliucheng.helpers.ModHelper;
import Qidongliucheng.utils.InstanceMaker;
import Qidongliucheng.utils.Invoker;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.EnemyMoveInfo;
import com.megacrit.cardcrawl.monsters.city.BronzeOrb;
import com.megacrit.cardcrawl.monsters.exordium.Lagavulin;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static Qidongliucheng.modcore.MyModConfig.countmax;
import static Qidongliucheng.modcore.MyModConfig.enableBronzeOrb;


public class jibaobingdu extends CustomRelic {
    public static final String ID = ModHelper.makePath(jibaobingdu.class.getSimpleName());

    public jibaobingdu() {
        super(ID, new Texture("qidongliuchengResources/images/relics/virus.png"), RelicTier.SPECIAL, LandingSound.CLINK);
        this.counter=0;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void atTurnStart() {
        super.atTurnStart();
        this.counter++;
        if (this.counter>countmax){
            return;
        }
        for (AbstractMonster monster : AbstractDungeon.getCurrRoom().monsters.monsters) {
           if (monster.isDying||monster.isDeadOrEscaped()){
               continue;
           }
           if (!enableBronzeOrb &&monster instanceof BronzeOrb){
               continue;
           }
           AbstractMonster am;
            am = InstanceMaker.getInstanceByClass(monster.getClass());
            if (am instanceof Lagavulin)
            {

                am=new Lagavulin(true);
            }
            am.init();
            am.applyPowers();
            am.createIntent();
            EnemyMoveInfo moveInfo= Invoker.getField(am,"move");


            Invoker.setField(monster,"move",moveInfo);
            monster.nextMove=am.nextMove;

            if (moveInfo != null) {
                System.out.println(am.name+am.moveName+"伤害"+moveInfo.baseDamage);
            }

        }

    }

    @Override
    public void onVictory() {
        super.onVictory();
        this.counter=0;
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {

        return super.onAttacked(info, damageAmount);
        }



    public AbstractRelic makeCopy() {
        return new jibaobingdu();
    }
}
