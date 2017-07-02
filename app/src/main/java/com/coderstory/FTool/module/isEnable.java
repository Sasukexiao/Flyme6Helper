package com.coderstory.FTool.module;


import com.coderstory.FTool.plugins.IModule;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;



public class isEnable implements IModule {


    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) {
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (lpparam.packageName.equals("com.coderstory.FTool")) {
            try {
                XposedHelpers.findAndHookMethod("com.coderstory.FTool.activity.MainActivity", lpparam.classLoader, "isEnable", XC_MethodReplacement.returnConstant(true));
            } catch (Throwable p1) {
                XposedBridge.log(p1);
            }
        }
    }

    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam paramStartupParam) {
    }

}
