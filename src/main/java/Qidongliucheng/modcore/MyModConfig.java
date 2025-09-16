package Qidongliucheng.modcore;




import Qidongliucheng.helpers.ModHelper;
import basemod.EasyConfigPanel;

public class MyModConfig extends EasyConfigPanel {
    public MyModConfig() {
        super(qidongliucheng.MyModID+"3", ModHelper.makePath(MyModConfig.class.getSimpleName()));


    }

    public static  boolean enableBronzeOrb =false;
    public static  int countmax=3;


}
