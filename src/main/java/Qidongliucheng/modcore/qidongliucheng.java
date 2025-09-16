package Qidongliucheng.modcore;


import Qidongliucheng.relics.jibaobingdu;
import basemod.*;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.Keyword;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


import static com.megacrit.cardcrawl.core.Settings.language;


@SpireInitializer
public class qidongliucheng implements StartActSubscriber,PostDungeonInitializeSubscriber,PostInitializeSubscriber,EditKeywordsSubscriber,OnStartBattleSubscriber, PostBattleSubscriber , EditStringsSubscriber, EditRelicsSubscriber,OnPlayerTurnStartSubscriber { // 实现接口
    public qidongliucheng() {
        BaseMod.subscribe(this); // 告诉basemod你要订阅事件
    }
    public static int turn=0;
    public static final String MyModID = "qidongliucheng";
    ModPanel settingsPanel = new ModPanel();
    public static SpireConfig config;
    public static boolean hasselected=false;
    public static boolean isfakefire;
    public static HashMap<Integer,Boolean> firemap=new HashMap<>();

    public static void initialize() throws IOException {

        new qidongliucheng();


    }

    // 当basemod开始注册mod卡牌时，便会调用这个函数

    @Override
    public void receiveStartAct() {

    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelic(new jibaobingdu(), RelicType.SHARED);
    }

    @Override
    public void receiveEditStrings() {
        String lang;
        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS"; // 如果语言设置为简体中文，则加载ZHS文件夹的资源
        } else {
            lang = "ENG"; // 如果没有相应语言的版本，默认加载英语
        }
    BaseMod.loadCustomStringsFile(RelicStrings.class, "qidongliuchengResources/localization/" + lang + "/relics.json");
        BaseMod.loadCustomStringsFile(UIStrings.class, "qidongliuchengResources/localization/" + lang + "/ui.json");

    }
    public static float getYPos(float y) {
        return Settings.HEIGHT/(2160/y);
    }
    public static float getXPos(float x) {
        return Settings.WIDTH/(3840/x);
    }
    @Override
    public void receivePostInitialize() {
        BaseMod.registerModBadge(ImageMaster.loadImage("qidongliuchengResources/images/relics/virus.png"),MyModID,"Dieyou", "怪物需要额外回合启动", new MyModConfig());

    }



    @Override
    public void receiveOnBattleStart(AbstractRoom abstractRoom) {

    }
   public static void initializeHashmap(){

   }
    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String lang = "ENG";
        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        }

        String json = Gdx.files.internal("qidongliuchengResources/localization/" + lang + "/keywords.json")
                .readString(String.valueOf(StandardCharsets.UTF_8));
        Keyword[] keywords = gson.fromJson(json, Keyword[].class);

    }

    @Override
    public void receiveOnPlayerTurnStart() {


    }

    @Override
    public void receivePostBattle(AbstractRoom abstractRoom) {

    }


    @Override
    public void receivePostDungeonInitialize() {
      jibaobingdu jibaobingdu1=new jibaobingdu();
      jibaobingdu1.instantObtain();
    }
}