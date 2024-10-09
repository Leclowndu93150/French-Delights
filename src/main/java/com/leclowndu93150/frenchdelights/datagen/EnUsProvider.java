package com.leclowndu93150.frenchdelights.datagen;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import com.leclowndu93150.frenchdelights.registry.FDItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(PackOutput output) {
        super(output, FrenchDelightsMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(FDItems.BAGUETTE.get(), "Baguette");
        add(FDItems.CROISSANT.get(), "Croissant");
        add(FDItems.PAIN_CHOCOLAT.get(), "Pain au Chocolat");
        add(FDItems.SALT.get(), "Salt");
        add(FDItems.WINE_BOTTLE.get(), "Wine Bottle");
        add(FDItems.WINE_GLASS.get(), "Wine Glass");
        add(FDItems.SALTED_DOUGH.get(), "Salted Dough");
    }
}
