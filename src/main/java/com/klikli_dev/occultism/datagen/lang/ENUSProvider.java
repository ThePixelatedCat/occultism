/*
 * MIT License
 *
 * Copyright 2021 vemerion, klikli-dev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.klikli_dev.occultism.datagen.lang;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.AbstractModonomiconLanguageProvider;
import com.klikli_dev.modonomicon.api.datagen.BookContextHelper;
import com.klikli_dev.occultism.Occultism;
import com.klikli_dev.occultism.TranslationKeys;
import com.klikli_dev.occultism.common.ritual.RitualFactory;
import com.klikli_dev.occultism.datagen.OccultismAdvancementSubProvider;
import com.klikli_dev.occultism.integration.modonomicon.OccultismModonomiconConstants.I18n;
import com.klikli_dev.occultism.registry.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class ENUSProvider extends AbstractModonomiconLanguageProvider {

    public static final String COLOR_PURPLE = "ad03fc";
    public static final String DEMONS_DREAM = "Demon's Dream";


    public ENUSProvider(PackOutput gen) {
        super(gen, Occultism.MODID, "en_us");
    }

    public void addItemMessages() {

        //"item\.occultism\.(.*?)\.(.*)": "(.*)",
        // this.add\(OccultismItems.\U\1\E.get\(\).getDescriptionId\(\)  + " \2", "\3"\);

        //book of callings use generic message base key, hence the manual string
        this.add("item.occultism.book_of_calling" + ".message_target_uuid_no_match", "This spirit is not currently bound to this book. Shift-Click the spirit to bind it to this book.");
        this.add("item.occultism.book_of_calling" + ".message_target_linked", "This spirit is now bound to this book.");
        this.add("item.occultism.book_of_calling" + ".message_target_cannot_link", "This spirit cannot be bound to this book - the book of calling needs to match the spirit's task!");
        this.add("item.occultism.book_of_calling" + ".message_target_entity_no_inventory", "This entity has no inventory, it cannot be set as deposit location.");
        this.add("item.occultism.book_of_calling" + ".message_spirit_not_found", "The spirit bound to this book is not dwelling on this plane of existence.");
        this.add("item.occultism.book_of_calling" + ".message_set_deposit", "%s will now deposit into %s from the side: %s");
        this.add("item.occultism.book_of_calling" + ".message_set_deposit_entity", "%s will now hand over items to: %s");
        this.add("item.occultism.book_of_calling" + ".message_set_extract", "%s will now extract from %s from the side: %s");
        this.add("item.occultism.book_of_calling" + ".message_set_base", "Set base for %s to %s");
        this.add("item.occultism.book_of_calling" + ".message_set_storage_controller", "%s will now accept work orders from %s");
        this.add("item.occultism.book_of_calling" + ".message_set_work_area_size", "%s will now monitor a work area of %s");
        this.add("item.occultism.book_of_calling" + ".message_set_managed_machine", "Updated machine settings for %s");
        this.add("item.occultism.book_of_calling" + ".message_set_managed_machine_extract_location", "%s will now extract from %s from the side: %s");
        this.add("item.occultism.book_of_calling" + ".message_no_managed_machine", "Set a managed machine before setting an extract location %s");

        this.add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".message.set_storage_controller", "Linked the stable wormhole to this storage actuator.");
        this.add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".message.not_loaded", "Chunk for storage actuator not loaded!");
        this.add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".message.linked", "Linked storage remote to actuator.");
        this.add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.no_linked_block", "The divination rod is not attuned to any material.");
        this.add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.linked_block", "The divination rod is now attuned to %s.");
        this.add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.no_link_found", "There is no resonance with this block.");
        this.add(OccultismItems.TRUE_SIGHT_STAFF.get().getDescriptionId() + ".message.no_linked_block", "The true sight rod is not attuned to any material.");
        this.add(OccultismItems.TRUE_SIGHT_STAFF.get().getDescriptionId() + ".message.linked_block", "The true sight rod is now attuned to %s.");
        this.add(OccultismItems.TRUE_SIGHT_STAFF.get().getDescriptionId() + ".message.no_link_found", "There is no resonance with this block.");
        this.add(OccultismItems.FRAGILE_SOUL_GEM_ITEM.get().getDescriptionId() + ".message.entity_type_denied", "Fragile soul gems cannot contain this type of being.");
        this.add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".message.entity_type_denied", "Soul gems cannot contain this type of being.");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".message.entity_type_denied", "Trinity gems cannot contain this type of being.");
    }

    public void addItemTooltips() {
        //"item\.occultism\.(.*?)\.(.*)": "(.*)",
        // this.add\(OccultismItems.\U\1\E.get\(\).getDescriptionId\(\)  + " \2", "\3"\);
        this.add(OccultismItems.BOOK_OF_BINDING_EMPTY.get().getDescriptionId() + ".tooltip", "This book has not been defined to any spirit yet.");
        this.add(OccultismItems.BOOK_OF_BINDING_FOLIOT.get().getDescriptionId() + ".tooltip", "This book has not been bound to a foliot yet.");
        this.add(OccultismItems.BOOK_OF_BINDING_BOUND_FOLIOT.get().getDescriptionId() + ".tooltip", "Can be used to summon the foliot %s");
        this.add(OccultismItems.BOOK_OF_BINDING_DJINNI.get().getDescriptionId() + ".tooltip", "This book has not been bound to a djinni yet.");
        this.add(OccultismItems.BOOK_OF_BINDING_BOUND_DJINNI.get().getDescriptionId() + ".tooltip", "Can be used to summon the djinni %s");
        this.add(OccultismItems.BOOK_OF_BINDING_AFRIT.get().getDescriptionId() + ".tooltip", "This book has not been bound to an afrit yet.");
        this.add(OccultismItems.BOOK_OF_BINDING_BOUND_AFRIT.get().getDescriptionId() + ".tooltip", "Can be used to summon the afrit %s");
        this.add(OccultismItems.BOOK_OF_BINDING_MARID.get().getDescriptionId() + ".tooltip", "This book has not been bound to a marid yet.");
        this.add(OccultismItems.BOOK_OF_BINDING_BOUND_MARID.get().getDescriptionId() + ".tooltip", "Can be used to summon the marid %s");

        this.add("item.occultism.book_of_calling_foliot" + ".tooltip", "Foliot %s");
        this.add("item.occultism.book_of_calling_foliot" + ".tooltip_dead", "%s has left this plane of existence.");
        this.add("item.occultism.book_of_calling_foliot" + ".tooltip.extract", "Extracts from: %s.");
        this.add("item.occultism.book_of_calling_foliot" + ".tooltip.deposit", "Deposits to: %s.");
        this.add("item.occultism.book_of_calling_foliot" + ".tooltip.deposit_entity", "Hands items over to: %s.");
        this.add("item.occultism.book_of_calling_djinni" + ".tooltip", "Djinni %s");
        this.add("item.occultism.book_of_calling_djinni" + ".tooltip_dead", "%s has left this plane of existence.");
        this.add("item.occultism.book_of_calling_djinni" + ".tooltip.extract", "Extracts from: %s.");
        this.add("item.occultism.book_of_calling_djinni" + ".tooltip.deposit", "Deposits to: % s");
        this.add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip", "Occupied by the familiar %s\n%s");
        this.add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip.familiar_type", "[Type: %s]");
        this.add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip.empty", "Does not contain any familiar.");

        this.add("item.minecraft.diamond_sword.occultism_spirit_tooltip", "%s is bound to this sword. May your foes tremor before its glory.");

        this.add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".tooltip.unlinked", "Not linked to a storage actuator.");
        this.add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".tooltip.linked", "Linked to storage actuator at %s.");
        this.add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".tooltip", "Access a storage network remotely.");
        this.add("block.occultism.otherglass.auto_tooltip", "Wear Otherworld Goggles to see it once placed");

        this.add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".tooltip.linked", "Bound to %s.");
        this.add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".tooltip.no_linked_block", "Not attuned to any material.");
        this.add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".tooltip.linked_block", "Attuned to %s.");
        this.add(OccultismItems.TRUE_SIGHT_STAFF.get().getDescriptionId() + ".tooltip.no_linked_block", "Not attuned to any material.");
        this.add(OccultismItems.TRUE_SIGHT_STAFF.get().getDescriptionId() + ".tooltip.linked_block", "Attuned to %s.");
        this.add(OccultismItems.DIMENSIONAL_MATRIX.get().getDescriptionId() + ".tooltip", "%s is bound to this dimensional matrix.");
        this.add(OccultismItems.INFUSED_PICKAXE.get().getDescriptionId() + ".tooltip", "%s is bound to this pickaxe.");
        this.add(OccultismItems.MINER_FOLIOT_UNSPECIALIZED.get().getDescriptionId() + ".tooltip", "%s will mine random blocks in the mining dimension.");
        this.add(OccultismItems.MINER_DJINNI_ORES.get().getDescriptionId() + ".tooltip", "%s will mine random ores in the mining dimension.");
        this.add(OccultismItems.MINER_DEBUG_UNSPECIALIZED.get().getDescriptionId() + ".tooltip", "Debug Miner will mine random blocks in the mining dimension.");
        this.add(OccultismItems.MINER_AFRIT_DEEPS.get().getDescriptionId() + ".tooltip", "%s will mine random ores and deepslate ores in the mining dimension.");
        this.add(OccultismItems.MINER_MARID_MASTER.get().getDescriptionId() + ".tooltip", "%s will mine random ores, deepslate ores and rare ores in the mining dimension.");
        this.add(OccultismItems.MINER_ANCIENT_ELDRITCH.get().getDescriptionId() + ".tooltip", "Something will mine random raw ores blocks, gems blocks and rare ores in the mining dimension.");
        this.add(OccultismItems.FRAGILE_SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_filled", "Contains a captured %s.\n" + ChatFormatting.RED + "Will break when release the creature!");
        this.add(OccultismItems.FRAGILE_SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_empty", "Use on a creature to capture it.\n" + ChatFormatting.RED + "Break after one use.");
        this.add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_filled", "Contains a captured %s.");
        this.add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_empty", "Use on a creature to capture it.");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".tooltip_filled", "Contains a captured %s.");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".tooltip_empty", "Use on a creature to capture it.\n" + ChatFormatting.GRAY + "Can capture bosses.");
        this.add(OccultismItems.SATCHEL.get().getDescriptionId() + ".tooltip", "%s is bound to this satchel.");
        this.add(OccultismItems.RITUAL_SATCHEL_T1.get().getDescriptionId() + ".tooltip", "%s is bound to this satchel.");
        this.add(OccultismItems.RITUAL_SATCHEL_T2.get().getDescriptionId() + ".tooltip", "%s is bound to this satchel.");

        this.add(OccultismItems.SOUL_SHARD_ITEM.get().getDescriptionId() + ".tooltip_filled", "Contains the soul of a %s.\nCan be used to resurrect it.");
        this.add(OccultismItems.SOUL_SHARD_ITEM.get().getDescriptionId() + ".tooltip_empty", "Dropped by a Familiar after their untimely death. Can be used to resurrect it.");
    }

    private void addItems() {
        //Notepad++ magic:
        //"item\.occultism\.(.*)": "(.*)"
        //this.addItem\(OccultismItems.\U\1\E, "\2"\);

        this.add("itemGroup.occultism", "Occultism");

        this.addItem(OccultismItems.PENTACLE_SUMMON, "Pentacle Summon");
        this.addItem(OccultismItems.PENTACLE_POSSESS, "Pentacle Possess");
        this.addItem(OccultismItems.PENTACLE_CRAFT, "Pentacle Craft");
        this.addItem(OccultismItems.PENTACLE_MISC, "Pentacle Misc");
        this.addItem(OccultismItems.REPAIR_ICON, "Repair Icon");
        this.addItem(OccultismItems.RESURRECT_ICON, "Resurrect Icon");
        this.addItem(OccultismItems.MYSTERIOUS_EGG_ICON, "Mysterious Egg Icon");
        this.addItem(OccultismItems.DEBUG_WAND, "Debug Wand");
        this.addItem(OccultismItems.DEBUG_FOLIOT_LUMBERJACK, "Summon Debug Foliot Lumberjack");
        this.addItem(OccultismItems.DEBUG_FOLIOT_TRANSPORT_ITEMS, "Summon Debug Foliot Transporter");
        this.addItem(OccultismItems.DEBUG_FOLIOT_CLEANER, "Summon Debug Foliot Janitor");
        this.addItem(OccultismItems.DEBUG_FOLIOT_TRADER_ITEM, "Summon Debug Foliot Trader");
        this.addItem(OccultismItems.DEBUG_DJINNI_MANAGE_MACHINE, "Summon Debug Djinni Manage Machine");
        this.addItem(OccultismItems.DEBUG_DJINNI_TEST, "Summon Debug Djinni Test");
        this.addAutoTooltip(OccultismItems.DIVINATION_ROD.get(),
                """
                        Don't see anything?
                        Check the Troubleshooting page in the Dictionary of Spirits!
                        In the "Getting Started" tab find the Divination Rod item.
                        """
        );
        this.addItem(OccultismItems.RITUAL_SATCHEL_T1, "Apprentice Ritual Satchel");
        this.addAutoTooltip(OccultismItems.RITUAL_SATCHEL_T1.get(),
                """
                        A basic ritual satchel that can place ritual circles block by block.
                        Right-Click a preview block to place it out of the satchel.
                        Shift-Right-Click to open the satchel and add ritual ingredients.
                        If an item inside has less than 40% of durability the glint effect will stop.
                        """
        );
        this.addItem(OccultismItems.RITUAL_SATCHEL_T2, "Artisanal Ritual Satchel");
        this.addAutoTooltip(OccultismItems.RITUAL_SATCHEL_T2.get(),
                """
                        An improved ritual satchel that can place an entire ritual circle at once.
                        Right-Click any preview block to place all preview blocks out of the satchel.
                        Shift-Right-Click to open the satchel and add ritual ingredients.
                        Right-Click a Golden Bowl to remove the ritual circle and collect the ingredients.
                        If an item inside has less than 40% of durability the glint effect will stop.
                        """
        );

        this.add(TranslationKeys.RITUAL_SATCHEL_NO_PREVIEW_IN_WORLD, " You need to preview a pentacle using the Dictionary of Spirits.");
        this.add(TranslationKeys.RITUAL_SATCHEL_NO_PREVIEW_BLOCK_TARGETED, "You need to aim the ritual satchel at a preview block.");
        this.add(TranslationKeys.RITUAL_SATCHEL_NO_VALID_ITEM_IN_SATCHEL, "There is no valid item in the satchel for this previewed block.");
        this.add(TranslationKeys.RITUAL_SATCHEL_BLOCK_ABOVE_NOT_AIR, "The block above the clicked position is not empty.");
        this.add(TranslationKeys.RITUAL_SATCHEL_BLOCK_AT_POSITION_NOT_AIR, "The block at the clicked position is not empty.");
        this.add(TranslationKeys.RITUAL_SATCHEL_INVALID_MATCHER, "Cannot place a block for an ANY or DISPLAY_ONLY multiblock matcher");

        this.addItem(OccultismItems.CHALK_YELLOW, "Yellow Chalk");
        this.addItem(OccultismItems.CHALK_PURPLE, "Purple Chalk");
        this.addItem(OccultismItems.CHALK_RED, "Red Chalk");
        this.addItem(OccultismItems.CHALK_WHITE, "White Chalk");
        this.addItem(OccultismItems.CHALK_LIGHT_GRAY, "Light Gray Chalk");
        this.addItem(OccultismItems.CHALK_GRAY, "Gray Chalk");
        this.addItem(OccultismItems.CHALK_BLACK, "Black Chalk");
        this.addItem(OccultismItems.CHALK_BROWN, "Brown Chalk");
        this.addItem(OccultismItems.CHALK_ORANGE, "Orange Chalk");
        this.addItem(OccultismItems.CHALK_LIME, "Lime Chalk");
        this.addItem(OccultismItems.CHALK_GREEN, "Green Chalk");
        this.addItem(OccultismItems.CHALK_CYAN, "Cyan Chalk");
        this.addItem(OccultismItems.CHALK_LIGHT_BLUE, "Light Blue Chalk");
        this.addItem(OccultismItems.CHALK_BLUE, "Blue Chalk");
        this.addItem(OccultismItems.CHALK_MAGENTA, "Magenta Chalk");
        this.addItem(OccultismItems.CHALK_PINK, "Pink Chalk");
        this.addItem(OccultismItems.CHALK_RAINBOW, "Rainbow Chalk");
        this.addItem(OccultismItems.CHALK_VOID, "Void Chalk");
        this.addItem(OccultismItems.CHALK_YELLOW_IMPURE, "Impure Yellow Chalk");
        this.addItem(OccultismItems.CHALK_PURPLE_IMPURE, "Impure Purple Chalk");
        this.addItem(OccultismItems.CHALK_RED_IMPURE, "Impure Red Chalk");
        this.addItem(OccultismItems.CHALK_WHITE_IMPURE, "Impure White Chalk");
        this.addItem(OccultismItems.CHALK_LIGHT_GRAY_IMPURE, "Impure Light Gray Chalk");
        this.addItem(OccultismItems.CHALK_GRAY_IMPURE, "Impure Gray Chalk");
        this.addItem(OccultismItems.CHALK_BLACK_IMPURE, "Impure Black Chalk");
        this.addItem(OccultismItems.CHALK_BROWN_IMPURE, "Impure Brown Chalk");
        this.addItem(OccultismItems.CHALK_ORANGE_IMPURE, "Impure Orange Chalk");
        this.addItem(OccultismItems.CHALK_LIME_IMPURE, "Impure Lime Chalk");
        this.addItem(OccultismItems.CHALK_GREEN_IMPURE, "Impure Green Chalk");
        this.addItem(OccultismItems.CHALK_CYAN_IMPURE, "Impure Cyan Chalk");
        this.addItem(OccultismItems.CHALK_LIGHT_BLUE_IMPURE, "Impure Light Blue Chalk");
        this.addItem(OccultismItems.CHALK_BLUE_IMPURE, "Impure Blue Chalk");
        this.addItem(OccultismItems.CHALK_MAGENTA_IMPURE, "Impure Magenta Chalk");
        this.addItem(OccultismItems.CHALK_PINK_IMPURE, "Impure Pink Chalk");
        this.addItem(OccultismItems.BRUSH, "Chalk Brush");
        this.addItem(OccultismItems.AFRIT_ESSENCE, "Afrit Essence");
        this.addItem(OccultismItems.PURIFIED_INK, "Purified Ink");
        this.addItem(OccultismItems.AWAKENED_FEATHER, "Awakened Feather");
        this.addItem(OccultismItems.TABOO_BOOK, "Taboo Book");
        this.addItem(OccultismItems.BOOK_OF_BINDING_EMPTY, "Book of Binding: Empty");
        this.addItem(OccultismItems.BOOK_OF_BINDING_FOLIOT, "Book of Binding: Foliot");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_FOLIOT, "Book of Binding: Foliot (Bound)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_DJINNI, "Book of Binding: Djinni");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_DJINNI, "Book of Binding: Djinni (Bound)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_AFRIT, "Book of Binding: Afrit");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_AFRIT, "Book of Binding: Afrit (Bound)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_MARID, "Book of Binding: Marid");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_MARID, "Book of Binding: Marid (Bound)");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_LUMBERJACK, "Book of Calling: Foliot Lumberjack");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_TRANSPORT_ITEMS, "Book of Calling: Foliot Transporter");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_CLEANER, "Book of Calling: Foliot Janitor");
        this.addItem(OccultismItems.BOOK_OF_CALLING_DJINNI_MANAGE_MACHINE, "Book of Calling: Djinni Machine Operator");
        this.addItem(OccultismItems.STORAGE_REMOTE, "Storage Accessor");
        this.addItem(OccultismItems.STORAGE_REMOTE_INERT, "Inert Storage Accessor");
        this.addItem(OccultismItems.DIMENSIONAL_MATRIX, "Dimensional Crystal Matrix");
        this.addItem(OccultismItems.DIVINATION_ROD, "Divination Rod");
        this.addItem(OccultismItems.TRUE_SIGHT_STAFF, "True Sight Staff");
        this.addItem(OccultismItems.DATURA_SEEDS, "Demon's Dream Seeds");
        this.addAutoTooltip(OccultismItems.DATURA_SEEDS.get(), "Plant to grow Demon's Dream Fruit.\nConsumption may allow to see beyond the veil ... it may also cause general un-wellness.");
        this.addItem(OccultismItems.DATURA, "Demon's Dream Fruit");
        this.addAutoTooltip(OccultismItems.DATURA.get(), "Consumption may allow to see beyond the veil ... it may also cause general un-wellness.");
        this.addItem(OccultismItems.DEMONS_DREAM_ESSENCE, "Demon's Dream Essence");
        this.addAutoTooltip(OccultismItems.DEMONS_DREAM_ESSENCE.get(), "Consumption allows to see beyond the veil ... and a whole lot of other effects.");
        this.addItem(OccultismItems.OTHERWORLD_ESSENCE, "Otherworld Essence");
        this.addAutoTooltip(OccultismItems.OTHERWORLD_ESSENCE.get(), "Purified Demon's Dream Essence, no longer provides any of the negative effects.");
        this.addItem(OccultismItems.BEAVER_NUGGET, "Beaver Nugget");
        this.addItem(OccultismItems.SPIRIT_ATTUNED_GEM, "Spirit Attuned Gem");
        this.add("item.occultism.otherworld_sapling", "Otherworld Sapling");
        this.add("item.occultism.otherworld_sapling_natural", "Unstable Otherworld Sapling");
        this.addItem(OccultismItems.OTHERWORLD_ASHES, "Otherworld Ashes");
        this.addItem(OccultismItems.BURNT_OTHERSTONE, "Burnt Otherstone");
        this.addItem(OccultismItems.BUTCHER_KNIFE, "Butcher Knife");
        this.addItem(OccultismItems.TALLOW, "Tallow");
        this.addItem(OccultismItems.OTHERSTONE_FRAME, "Otherstone Frame");
        this.addItem(OccultismItems.OTHERSTONE_TABLET, "Otherstone Tablet");
        this.addItem(OccultismItems.WORMHOLE_FRAME, "Wormhole Frame");
        this.addItem(OccultismItems.IRON_DUST, "Iron Dust");
        this.addItem(OccultismItems.OBSIDIAN_DUST, "Obsidian Dust");
        this.addItem(OccultismItems.CRUSHED_END_STONE, "Crushed End Stone");
        this.addItem(OccultismItems.GOLD_DUST, "Gold Dust");
        this.addItem(OccultismItems.COPPER_DUST, "Copper Dust");
        this.addItem(OccultismItems.SILVER_DUST, "Silver Dust");
        this.addItem(OccultismItems.IESNIUM_DUST, "Iesnium Dust");
        this.addItem(OccultismItems.RAW_SILVER, "Raw Silver");
        this.addItem(OccultismItems.RAW_IESNIUM, "Raw Iesnium");
        this.addItem(OccultismItems.SILVER_INGOT, "Silver Ingot");
        this.addItem(OccultismItems.IESNIUM_INGOT, "Iesnium Ingot");
        this.addItem(OccultismItems.SILVER_NUGGET, "Silver Nugget");
        this.addItem(OccultismItems.IESNIUM_NUGGET, "Iesnium Nugget");
        this.addItem(OccultismItems.LENSES, "Glass Lenses");
        this.addItem(OccultismItems.INFUSED_LENSES, "Infused Lenses");
        this.addItem(OccultismItems.LENS_FRAME, "Lens Frame");
        this.addItem(OccultismItems.OTHERWORLD_GOGGLES, "Otherworld Goggles");
        this.addItem(OccultismItems.INFUSED_PICKAXE, "Infused Pickaxe");
        this.addItem(OccultismItems.SPIRIT_ATTUNED_PICKAXE_HEAD, "Spirit Attuned Pickaxe Head");
        this.addItem(OccultismItems.IESNIUM_PICKAXE, "Iesnium Pickaxe");
        this.addItem(OccultismItems.MAGIC_LAMP_EMPTY, "Empty Magic Lamp");
        this.addItem(OccultismItems.MINER_FOLIOT_UNSPECIALIZED, "Miner Foliot");
        this.addItem(OccultismItems.MINER_DJINNI_ORES, "Ore Miner Djinni");
        this.addItem(OccultismItems.MINER_DEBUG_UNSPECIALIZED, "Debug Miner");
        this.addItem(OccultismItems.MINER_AFRIT_DEEPS, "Deep Ore Miner Afrit");
        this.addItem(OccultismItems.MINER_MARID_MASTER, "Master Miner Marid");
        this.addItem(OccultismItems.MINER_ANCIENT_ELDRITCH, "Eldritch Ancient Miner");
        this.addItem(OccultismItems.MINING_DIMENSION_CORE_PIECE, "Mining Dimension Core Piece");
        this.addItem(OccultismItems.FRAGILE_SOUL_GEM_ITEM, "Fragile Soul Gem");
        this.add(OccultismItems.FRAGILE_SOUL_GEM_ITEM.get().getDescriptionId() + "_empty", "Fragile Empty Soul Gem");
        this.addItem(OccultismItems.SOUL_GEM_ITEM, "Soul Gem");
        this.add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + "_empty", "Empty Soul Gem");
        this.addItem(OccultismItems.TRINITY_GEM_ITEM, "Trinity Gem");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + "_empty", "Empty Trinity Gem");
        this.addItem(OccultismItems.SOUL_SHARD_ITEM, "Soul Shard");
        this.addItem(OccultismItems.SATCHEL, "Surprisingly Substantial Satchel");
        this.addItem(OccultismItems.FAMILIAR_RING, "Familiar Ring");
        this.addItem(OccultismItems.SPAWN_EGG_FOLIOT, "Foliot Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DJINNI, "Djinni Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_AFRIT, "Afrit Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_AFRIT_UNBOUND, "Unbound Afrit Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_MARID, "Marid Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_MARID_UNBOUND, "Unbound Marid Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ENDERMITE, "Possessed Endermite Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_SKELETON, "Possessed Skeleton Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ENDERMAN, "Possessed Enderman Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_GHAST, "Possessed Ghast Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_PHANTOM, "Possessed Phantom Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WEAK_SHULKER, "Possessed Weak Shulker Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_SHULKER, "Possessed Shulker Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ELDER_GUARDIAN, "Possessed Elder Guardian Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WARDEN, "Possessed Warden Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_HOGLIN, "Possessed Hoglin Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WITCH, "Possessed Witch Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ZOMBIE_PIGLIN, "Possessed Zombified Piglin Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_BEE, "Possessed Bee Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_GOAT_OF_MERCY, "Goat of Mercy Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HUNT_SKELETON, "Wild Hunt Skeleton Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HUNT_WITHER_SKELETON, "Wild Hunt Wither Skeleton Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_OTHERWORLD_BIRD, "Drikwing Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_GREEDY_FAMILIAR, "Greedy Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_BAT_FAMILIAR, "Bat Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DEER_FAMILIAR, "Deer Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_CTHULHU_FAMILIAR, "Cthulhu Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DEVIL_FAMILIAR, "Devil Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DRAGON_FAMILIAR, "Dragon Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_BLACKSMITH_FAMILIAR, "Blacksmith Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_GUARDIAN_FAMILIAR, "Guardian Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_HEADLESS_FAMILIAR, "Headless Ratman Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_CHIMERA_FAMILIAR, "Chimera Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_GOAT_FAMILIAR, "Goat Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_SHUB_NIGGURATH_FAMILIAR, "Shub Niggurath Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_BEHOLDER_FAMILIAR, "Beholder Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_FAIRY_FAMILIAR, "Fairy Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_MUMMY_FAMILIAR, "Mummy Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_BEAVER_FAMILIAR, "Beaver Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_PARROT_FAMILIAR, "Parrot Familiar Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DEMONIC_WIFE, "Demonic Wife Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_DEMONIC_HUSBAND, "Demonic Husband Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_IESNIUM_GOLEM, "Iesnium Golem Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_HUSK, "Wild Horde Husk Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_DROWNED, "Wild Horde Drowned Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_CREEPER, "Wild Horde Creeper Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_SILVERFISH, "Wild Horde Silverfish Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_WEAK_BREEZE, "Wild Weak Breeze Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_BREEZE, "Wild Breeze Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_STRONG_BREEZE, "Wild Strong Breeze Spawn Egg");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_EVOKER, "Wild Evoker Spawn Egg");
        //Pentacle Rework Update
        this.addItem(OccultismItems.AMETHYST_DUST,"Amethyst Dust");
        this.addItem(OccultismItems.CRUELTY_ESSENCE,"Cruelty Essence");
        this.addItem(OccultismItems.CRUSHED_BLACKSTONE,"Crushed Blackstone");
        this.addItem(OccultismItems.CRUSHED_BLUE_ICE,"Crushed Blue Ice");
        this.addItem(OccultismItems.CRUSHED_CALCITE,"Crushed Calcite");
        this.addItem(OccultismItems.CRUSHED_ICE,"Crushed Ice");
        this.addItem(OccultismItems.CRUSHED_PACKED_ICE,"Crushed Packed Ice");
        this.addItem(OccultismItems.CURSED_HONEY,"Cursed Honey");
        this.addItem(OccultismItems.DEMONIC_MEAT,"Demonic Meat");
        this.addItem(OccultismItems.DRAGONYST_DUST,"Dragonyst Dust");
        this.addItem(OccultismItems.ECHO_DUST,"Echo Dust");
        this.addItem(OccultismItems.EMERALD_DUST,"Emerald Dust");
        this.addItem(OccultismItems.GRAY_PASTE,"Gray Paste");
        this.addItem(OccultismItems.LAPIS_DUST,"Lapis Dust");
        this.addItem(OccultismItems.MARID_ESSENCE,"Marid Essence");
        this.addItem(OccultismItems.NATURE_PASTE,"Nature Paste");
        this.addItem(OccultismItems.NETHERITE_DUST,"Netherite Dust");
        this.addItem(OccultismItems.NETHERITE_SCRAP_DUST,"Netherite Scrap Dust");
        this.addItem(OccultismItems.RESEARCH_FRAGMENT_DUST,"Research Fragment Dust");
        this.addItem(OccultismItems.WITHERITE_DUST,"Witherite Dust");
    }

    private void addBlocks() {
        //"block\.occultism\.(.*?)": "(.*)",
        //this.addBlock\(OccultismItems.\U\1\E, "\2"\);
        this.addBlock(OccultismBlocks.OTHERGLASS, "Otherglass");
        this.addBlock(OccultismBlocks.OTHERSTONE, "Otherstone");
        this.addBlock(OccultismBlocks.OTHERSTONE_STAIRS, "Otherstone Stairs");
        this.addBlock(OccultismBlocks.OTHERSTONE_SLAB, "Otherstone Slab");
        this.addBlock(OccultismBlocks.OTHERSTONE_PRESSURE_PLATE, "Otherstone Pressure Plate");
        this.addBlock(OccultismBlocks.OTHERSTONE_BUTTON, "Otherstone Button");
        this.addBlock(OccultismBlocks.OTHERSTONE_WALL, "Otherstone Wall");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE, "Othercobblestone");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_STAIRS, "Othercobblestone Stairs");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_SLAB, "Othercobblestone Slab");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_WALL, "Othercobblestone Wall");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE, "Polished Otherstone");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_STAIRS, "Polished Otherstone Stairs");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_SLAB, "Polished Otherstone Slab");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_WALL, "Polished Otherstone Wall");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS, "Otherstone Bricks");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_STAIRS, "Otherstone Bricks Stairs");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_SLAB, "Otherstone Bricks Slab");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_WALL, "Otherstone Bricks Wall");
        this.addBlock(OccultismBlocks.CHISELED_OTHERSTONE_BRICKS, "Chiseled Otherstone Bricks");
        this.addBlock(OccultismBlocks.CRACKED_OTHERSTONE_BRICKS, "Cracked Otherstone Bricks");
        this.addBlock(OccultismBlocks.OTHERSTONE_PEDESTAL, "Otherstone Pedestal");
        this.addBlock(OccultismBlocks.OTHERSTONE_PEDESTAL_SILVER, "Silver Otherstone Pedestal");
        this.addBlock(OccultismBlocks.SACRIFICIAL_BOWL, "Sacrificial Bowl");
        this.addBlock(OccultismBlocks.COPPER_SACRIFICIAL_BOWL, "Copper Sacrificial Bowl");
        this.addBlock(OccultismBlocks.SILVER_SACRIFICIAL_BOWL, "Silver Sacrificial Bowl");
        this.addBlock(OccultismBlocks.GOLDEN_SACRIFICIAL_BOWL, "Golden Sacrificial Bowl");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_WHITE, "White Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_YELLOW, "Yellow Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_PURPLE, "Purple Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_RED, "Red Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_LIGHT_GRAY, "Light Gray Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_GRAY, "Gray Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BLACK, "Black Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BROWN, "Brown Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_ORANGE, "Orange Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_LIME, "Lime Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_GREEN, "Green Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_CYAN, "Cyan Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_LIGHT_BLUE, "Light Blue Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BLUE, "Blue Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_MAGENTA, "Magenta Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_PINK, "Pink Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_RAINBOW, "Rainbow Chalk Glyph");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_VOID, "Void Chalk Glyph");
        this.addBlock(OccultismBlocks.STORAGE_CONTROLLER, "Dimensional Storage Actuator");
        this.addBlock(OccultismBlocks.STORAGE_CONTROLLER_STABILIZED, "Stabilized Dimensional Storage Actuator");
        this.addBlock(OccultismBlocks.STORAGE_CONTROLLER_BASE, "Storage Actuator Base");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER0, "Dimensional Storage Stabilizer Base");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER1, "Tier 1 Dimensional Storage Stabilizer");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER2, "Tier 2 Dimensional Storage Stabilizer");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER3, "Tier 3 Dimensional Storage Stabilizer");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER4, "Tier 4 Dimensional Storage Stabilizer");
        this.addBlock(OccultismBlocks.STABLE_WORMHOLE, "Stable Wormhole");
        this.addBlock(OccultismBlocks.DATURA, "Demon's Dream");
        this.addBlock(OccultismBlocks.OTHERFLOWER, "Otherflower");
        this.addBlock(OccultismBlocks.OTHERWORLD_SAPLING, "Otherworld Sapling");
        this.addBlock(OccultismBlocks.OTHERWORLD_LEAVES, "Otherworld Leaves");
        this.addBlock(OccultismBlocks.OTHERWORLD_LOG, "Otherworld Log");
        this.addBlock(OccultismBlocks.OTHERWORLD_WOOD, "Otherworld Wood");
        this.addBlock(OccultismBlocks.STRIPPED_OTHERWORLD_LOG, "Stripped Otherworld Log");
        this.addBlock(OccultismBlocks.STRIPPED_OTHERWORLD_WOOD, "Stripped Otherworld Wood");
        this.addBlock(OccultismBlocks.OTHERPLANKS, "Otherplanks");
        this.addBlock(OccultismBlocks.OTHERPLANKS_STAIRS, "Otherplanks Stairs");
        this.addBlock(OccultismBlocks.OTHERPLANKS_SLAB, "Otherplanks Slab");
        this.addBlock(OccultismBlocks.OTHERPLANKS_FENCE, "Otherplanks Fence");
        this.addBlock(OccultismBlocks.OTHERPLANKS_FENCE_GATE, "Otherplanks Fence Gate");
        this.addBlock(OccultismBlocks.OTHERPLANKS_DOOR, "Otherplanks Door");
        this.addBlock(OccultismBlocks.OTHERPLANKS_TRAPDOOR, "Otherplanks Trapdoor");
        this.addBlock(OccultismBlocks.OTHERPLANKS_PRESSURE_PLATE, "Otherplanks Pressure Plate");
        this.addBlock(OccultismBlocks.OTHERPLANKS_BUTTON, "Otherplanks Button");
        this.addBlock(OccultismBlocks.OTHERPLANKS_SIGN, "Otherplanks Sign");
        this.addBlock(OccultismBlocks.OTHERPLANKS_HANGING_SIGN, "Otherplanks Hanging Sign");
        this.addBlock(OccultismBlocks.TALLOW_BLOCK, "Tallow Block");
        this.addBlock(OccultismBlocks.SPIRIT_FIRE, "Spiritfire");
        this.addBlock(OccultismBlocks.SPIRIT_ATTUNED_CRYSTAL, "Spirit Attuned Crystal");
        this.addBlock(OccultismBlocks.LARGE_CANDLE, "Large Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_WHITE, "Large White Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIGHT_GRAY, "Large Light Gray Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_GRAY, "Large Gray Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BLACK, "Large Black Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BROWN, "Large Brown Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_RED, "Large Red Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_ORANGE, "Large Orange Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_YELLOW, "Large Yellow Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIME, "Large Lime Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_GREEN, "Large Green Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_CYAN, "Large Cyan Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BLUE, "Large Blue Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIGHT_BLUE, "Large Light Blue Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_PINK, "Large Pink Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_MAGENTA, "Large Magenta Candle");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_PURPLE, "Large Purple Candle");
        this.addBlock(OccultismBlocks.SILVER_ORE, "Silver Ore");
        this.addBlock(OccultismBlocks.SILVER_ORE_DEEPSLATE, "Deepslate Silver Ore");
        this.addBlock(OccultismBlocks.IESNIUM_ANVIL, "Iesnium Anvil");
        this.addBlock(OccultismBlocks.IESNIUM_ORE, "Iesnium Ore");
        this.addBlock(OccultismBlocks.SILVER_BLOCK, "Block of Silver");
        this.addBlock(OccultismBlocks.IESNIUM_BLOCK, "Block of Iesnium");
        this.addBlock(OccultismBlocks.IESNIUM_SACRIFICIAL_BOWL, "Iesnium Sacrificial Bowl");
        this.addBlock(OccultismBlocks.RAW_SILVER_BLOCK, "Block of Raw Silver");
        this.addBlock(OccultismBlocks.RAW_IESNIUM_BLOCK, "Block of Raw Iesnium");
        this.addBlock(OccultismBlocks.DIMENSIONAL_MINESHAFT, "Dimensional Mineshaft");
        this.addBlock(OccultismBlocks.SKELETON_SKULL_DUMMY, "Skeleton Skull");
        this.addBlock(OccultismBlocks.WITHER_SKELETON_SKULL_DUMMY, "Wither Skeleton Skull");
        this.addBlock(OccultismBlocks.LIGHTED_AIR, "Lighted Air");
        this.addBlock(OccultismBlocks.SPIRIT_LANTERN, "Spirit Lantern");
        this.addBlock(OccultismBlocks.SPIRIT_CAMPFIRE, "Spirit Campfire");
        this.addBlock(OccultismBlocks.SPIRIT_TORCH, "Spirit Torch"); //spirit wall torch automatically uses the same translation
        this.addBlock(OccultismBlocks.ELDRITCH_CHALICE, "Eldritch Chalice");
    }

    private void addEntities() {
        //"entity\.occultism\.(.*?)": "(.*)",
        //this.addEntityType\(OccultismEntities.\U\1\E, "\2"\);

        this.addEntityType(OccultismEntities.FOLIOT, "Foliot");
        this.addEntityType(OccultismEntities.DJINNI, "Djinni");
        this.addEntityType(OccultismEntities.AFRIT, "Afrit");
        this.addEntityType(OccultismEntities.AFRIT_WILD, "Unbound Afrit");
        this.addEntityType(OccultismEntities.MARID, "Marid");
        this.addEntityType(OccultismEntities.MARID_UNBOUND, "Unbound Marid");
        this.addEntityType(OccultismEntities.POSSESSED_ENDERMITE, "Possessed Endermite");
        this.addEntityType(OccultismEntities.POSSESSED_SKELETON, "Possessed Skeleton");
        this.addEntityType(OccultismEntities.POSSESSED_ENDERMAN, "Possessed Enderman");
        this.addEntityType(OccultismEntities.POSSESSED_GHAST, "Possessed Ghast");
        this.addEntityType(OccultismEntities.POSSESSED_PHANTOM, "Possessed Phantom");
        this.addEntityType(OccultismEntities.POSSESSED_WEAK_SHULKER, "Possessed Weak Shulker");
        this.addEntityType(OccultismEntities.POSSESSED_SHULKER, "Possessed Shulker");
        this.addEntityType(OccultismEntities.POSSESSED_ELDER_GUARDIAN, "Possessed Elder Guardian");
        this.addEntityType(OccultismEntities.POSSESSED_WARDEN, "Possessed Warden");
        this.addEntityType(OccultismEntities.POSSESSED_HOGLIN, "Possessed Hoglin");
        this.addEntityType(OccultismEntities.POSSESSED_WITCH, "Possessed Witch");
        this.addEntityType(OccultismEntities.POSSESSED_ZOMBIE_PIGLIN, "Possessed Zombified Piglin");
        this.addEntityType(OccultismEntities.POSSESSED_BEE, "Possessed Bee");
        this.addEntityType(OccultismEntities.GOAT_OF_MERCY, "Goat of Mercy");
        this.addEntityType(OccultismEntities.WILD_HUNT_SKELETON, "Wild Hunt Skeleton");
        this.addEntityType(OccultismEntities.WILD_HUNT_WITHER_SKELETON, "Wild Hunt Wither Skeleton");
        this.addEntityType(OccultismEntities.OTHERWORLD_BIRD, "Drikwing");
        this.addEntityType(OccultismEntities.GREEDY_FAMILIAR, "Greedy Familiar");
        this.addEntityType(OccultismEntities.BAT_FAMILIAR, "Bat Familiar");
        this.addEntityType(OccultismEntities.DEER_FAMILIAR, "Deer Familiar");
        this.addEntityType(OccultismEntities.CTHULHU_FAMILIAR, "Cthulhu Familiar");
        this.addEntityType(OccultismEntities.DEVIL_FAMILIAR, "Devil Familiar");
        this.addEntityType(OccultismEntities.DRAGON_FAMILIAR, "Dragon Familiar");
        this.addEntityType(OccultismEntities.BLACKSMITH_FAMILIAR, "Blacksmith Familiar");
        this.addEntityType(OccultismEntities.GUARDIAN_FAMILIAR, "Guardian Familiar");
        this.addEntityType(OccultismEntities.HEADLESS_FAMILIAR, "Headless Familiar");
        this.addEntityType(OccultismEntities.CHIMERA_FAMILIAR, "Chimera Familiar");
        this.addEntityType(OccultismEntities.GOAT_FAMILIAR, "Goat Familiar");
        this.addEntityType(OccultismEntities.SHUB_NIGGURATH_FAMILIAR, "Shub Niggurath Familiar");
        this.addEntityType(OccultismEntities.BEHOLDER_FAMILIAR, "Beholder Familiar");
        this.addEntityType(OccultismEntities.FAIRY_FAMILIAR, "Fairy Familiar");
        this.addEntityType(OccultismEntities.MUMMY_FAMILIAR, "Mummy Familiar");
        this.addEntityType(OccultismEntities.BEAVER_FAMILIAR, "Beaver Familiar");
        this.addEntityType(OccultismEntities.SHUB_NIGGURATH_SPAWN, "Shub Niggurath Spawn");
        this.addEntityType(OccultismEntities.THROWN_SWORD, "Thrown Sword");
        this.addEntityType(OccultismEntities.DEMONIC_WIFE, "Demonic Wife");
        this.addEntityType(OccultismEntities.DEMONIC_HUSBAND, "Demonic Husband");
        this.addEntityType(OccultismEntities.IESNIUM_GOLEM, "Iesnium Golem");
        this.addEntityType(OccultismEntities.WILD_HORDE_HUSK, "Wild Horde Husk");
        this.addEntityType(OccultismEntities.WILD_HORDE_DROWNED, "Wild Horde Drowned");
        this.addEntityType(OccultismEntities.WILD_HORDE_CREEPER, "Wild Horde Creeper");
        this.addEntityType(OccultismEntities.WILD_HORDE_SILVERFISH, "Wild Horde Silverfish");
        this.addEntityType(OccultismEntities.POSSESSED_WEAK_BREEZE, "Wild Weak Breeze");
        this.addEntityType(OccultismEntities.POSSESSED_BREEZE, "Wild Breeze");
        this.addEntityType(OccultismEntities.POSSESSED_STRONG_BREEZE, "Wild Strong Breeze");
        this.addEntityType(OccultismEntities.WILD_ZOMBIE, "Wild Zombie");
        this.addEntityType(OccultismEntities.WILD_SKELETON, "Wild Skeleton");
        this.addEntityType(OccultismEntities.WILD_SILVERFISH, "Wild Silverfish");
        this.addEntityType(OccultismEntities.WILD_SPIDER, "Wild Spider");
        this.addEntityType(OccultismEntities.WILD_BOGGED, "Wild Bogged");
        this.addEntityType(OccultismEntities.WILD_SLIME, "Wild Slime");
        this.addEntityType(OccultismEntities.WILD_HUSK, "Wild Husk");
        this.addEntityType(OccultismEntities.WILD_STRAY, "Wild Stray");
        this.addEntityType(OccultismEntities.WILD_CAVE_SPIDER, "Wild Cave Spider");
        this.addEntityType(OccultismEntities.POSSESSED_EVOKER, "Wild Evoker");
    }

    private void addMiscTranslations() {

        //"(.*?)": "(.*)",
        //this.add\("\1", "\2"\);

        this.add(TranslationKeys.HUD_NO_PENTACLE_FOUND, "No valid pentacle found.");
        this.add(TranslationKeys.HUD_PENTACLE_FOUND, "Current Pentacle: %s");

        this.add(TranslationKeys.MESSAGE_CONTAINER_ALREADY_OPEN, "This container is already opened by another player, wait until they close it.");

        //Jobs
        this.add("job.occultism.lumberjack", "Lumberjack");
        this.add("job.occultism.crush_tier1", "Slow Crusher");
        this.add("job.occultism.crush_tier2", "Crusher");
        this.add("job.occultism.crush_tier3", "Fast Crusher");
        this.add("job.occultism.crush_tier4", "Very Fast Crusher");
        this.add("job.occultism.smelt_tier1", "Slow Smelter");
        this.add("job.occultism.smelt_tier2", "Smelter");
        this.add("job.occultism.smelt_tier3", "Fast Smelter");
        this.add("job.occultism.smelt_tier4", "Very Fast Smelter");
        this.add("job.occultism.manage_machine", "Machine Operator");
        this.add("job.occultism.transport_items", "Transporter");
        this.add("job.occultism.cleaner", "Janitor");
        this.add("job.occultism.trade_otherstone_t1", "Otherstone Trader");
        this.add("job.occultism.trade_otherworld_saplings_t1", "Otherworld Sapling Trader");
        this.add("job.occultism.clear_weather", "Sunshine Spirit");
        this.add("job.occultism.rain_weather", "Rainy Weather Spirit");
        this.add("job.occultism.thunder_weather", "Thunderstorm Spirit");
        this.add("job.occultism.day_time", "Dawn Spirit");
        this.add("job.occultism.night_time", "Dusk Spirit");

        //Enums
        this.add("enum.occultism.facing.up", "Up");
        this.add("enum.occultism.facing.down", "Down");
        this.add("enum.occultism.facing.north", "North");
        this.add("enum.occultism.facing.south", "South");
        this.add("enum.occultism.facing.west", "West");
        this.add("enum.occultism.facing.east", "East");
        this.add("enum.occultism.book_of_calling.item_mode.set_deposit", "Set Deposit");
        this.add("enum.occultism.book_of_calling.item_mode.set_extract", "Set Extract");
        this.add("enum.occultism.book_of_calling.item_mode.set_base", "Set Base Location");
        this.add("enum.occultism.book_of_calling.item_mode.set_storage_controller", "Set Storage Actuator");
        this.add("enum.occultism.book_of_calling.item_mode.set_managed_machine", "Set Managed Machine");
        this.add("enum.occultism.work_area_size.small", "16x16");
        this.add("enum.occultism.work_area_size.medium", "32x32");
        this.add("enum.occultism.work_area_size.large", "64x64");

        //Debug messages
        this.add("debug.occultism.debug_wand.printed_glyphs", "Printed glyphs");
        this.add("debug.occultism.debug_wand.glyphs_verified", "Glyphs verified");
        this.add("debug.occultism.debug_wand.glyphs_not_verified", "Glyphs not verified");
        this.add("debug.occultism.debug_wand.spirit_selected", "Selected spirit with id %s");
        this.add("debug.occultism.debug_wand.spirit_tamed", "Tamed spirit with id %s");
        this.add("debug.occultism.debug_wand.deposit_selected", "Set deposit block %s, facing %s");
        this.add("debug.occultism.debug_wand.no_spirit_selected", "No spirit selected.");

        //Ritual Sacrifices
        this.add("ritual.occultism.sacrifice.cows", "Cow");
        this.add("ritual.occultism.sacrifice.bats", "Bat");
        this.add("ritual.occultism.sacrifice.bees", "Bee");
        this.add("ritual.occultism.sacrifice.zombies", "Zombie");
        this.add("ritual.occultism.sacrifice.parrots", "Parrot");
        this.add("ritual.occultism.sacrifice.chicken", "Chicken");
        this.add("ritual.occultism.sacrifice.pigs", "Pigs");
        this.add("ritual.occultism.sacrifice.humans", "Villager or Player");
        this.add("ritual.occultism.sacrifice.squid", "Squid");
        this.add("ritual.occultism.sacrifice.horses", "Horse");
        this.add("ritual.occultism.sacrifice.sheep", "Sheep");
        this.add("ritual.occultism.sacrifice.llamas", "Llama");
        this.add("ritual.occultism.sacrifice.goats", "Goat");
        this.add("ritual.occultism.sacrifice.snow_golem", "Snow Golem");
        this.add("ritual.occultism.sacrifice.iron_golem", "Iron Golem");
        this.add("ritual.occultism.sacrifice.spiders", "Spider");
        this.add("ritual.occultism.sacrifice.flying_passive", "Allay, Bat, Bee or Parrot");
        this.add("ritual.occultism.sacrifice.cubemob", "Slime or Magma Cube");
        this.add("ritual.occultism.sacrifice.fish", "Any Fish");
        this.add("ritual.occultism.sacrifice.axolotls", "Axolotl");
        this.add("ritual.occultism.sacrifice.camel", "Camel");
        this.add("ritual.occultism.sacrifice.dolphin", "Dolphin");
        this.add("ritual.occultism.sacrifice.wolfs", "Wolf");
        this.add("ritual.occultism.sacrifice.ocelot", "Ocelot");
        this.add("ritual.occultism.sacrifice.cats", "Cat");
        this.add("ritual.occultism.sacrifice.vex", "Vex");
        this.add("ritual.occultism.sacrifice.tadpoles", "Tadpole");
        this.add("ritual.occultism.sacrifice.allay", "Allay");
        this.add("ritual.occultism.sacrifice.warden", "Warden");
        this.add("ritual.occultism.sacrifice.ravager", "Ravager");

        //Network Message
        this.add("network.messages.occultism.request_order.order_received", "Order received!");

        //Effects
        this.add("effect.occultism.third_eye", "Third Eye");
        this.add("effect.occultism.double_jump", "Multi Jump");
        this.add("effect.occultism.dragon_greed", "Dragon's Greed");
        this.add("effect.occultism.mummy_dodge", "Dodge");
        this.add("effect.occultism.bat_lifesteal", "Lifesteal");
        this.add("effect.occultism.beaver_harvest", "Beaver Harvest");
        this.add("effect.occultism.step_height", "Step Height");

        //Sounds
        this.add("occultism.subtitle.chalk", "Chalk");
        this.add("occultism.subtitle.brush", "Brush");
        this.add("occultism.subtitle.start_ritual", "Start Ritual");
        this.add("occultism.subtitle.tuning_fork", "Tuning Fork");
        this.add("occultism.subtitle.crunching", "Crunching");
        this.add("occultism.subtitle.poof", "Poof!");

        //Dimension types

        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.OVERWORLD.location()), "Overworld");
        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.NETHER.location()), "Nether");
        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.END.location()), "The End");
    }

    private void addGuiTranslations() {
        this.add("gui.occultism.book_of_calling.mode", "Mode");
        this.add("gui.occultism.book_of_calling.work_area", "Work Area");
        this.add("gui.occultism.book_of_calling.manage_machine.insert", "Insert Facing");
        this.add("gui.occultism.book_of_calling.manage_machine.extract", "Extract Facing");
        this.add("gui.occultism.book_of_calling.manage_machine.custom_name", "Custom Name");

        // Spirit GUI
        this.add("gui.occultism.spirit.age", "Essence Decay: %d%%");
        this.add("gui.occultism.spirit.job", "%s");

        // Spirit Transporter GUI
        this.add("gui.occultism.spirit.transporter.filter_mode", "Filter Mode");
        this.add("gui.occultism.spirit.transporter.filter_mode.blacklist", "Blacklist");
        this.add("gui.occultism.spirit.transporter.filter_mode.whitelist", "Whitelist");
        this.add("gui.occultism.spirit.transporter.tag_filter", "Enter the tags to filter for separated by \";\".\nE.g.: \"c:ores;*logs*\".\nUse \"*\" to match any character, e.g. \"*ore*\" to match ore tags from any mod. To filter for items, prefix the item id with \"item:\", E.g.: \"item:minecraft:chest\".");

        // Storage Controller GUI
        this.add("gui.occultism.storage_controller.space_info_label", "%d/%d");
        this.add("gui.occultism.storage_controller.space_info_label_new", "%s%% filled");
        this.add("gui.occultism.storage_controller.space_info_label_types", "%s%% of types");
        this.add("gui.occultism.storage_controller.shift", "Hold shift for more information.");
        this.add("gui.occultism.storage_controller.search.tooltip@", "Prefix @: Search mod id.");
        this.add("gui.occultism.storage_controller.search.tooltip#", "Prefix #: Search in item tooltip.");
        this.add("gui.occultism.storage_controller.search.tooltip$", "Prefix $: Search for Tag.");
        this.add("gui.occultism.storage_controller.search.tooltip_rightclick", "Clear the text with a right-click.");
        this.add("gui.occultism.storage_controller.search.tooltip_clear", "Clear search.");
        this.add("gui.occultism.storage_controller.search.tooltip_jei_on", "Sync search with JEI.");
        this.add("gui.occultism.storage_controller.search.tooltip_jei_off", "Do not sync search with JEI.");
        this.add("gui.occultism.storage_controller.search.tooltip_sort_type_amount", "Sort by amount.");
        this.add("gui.occultism.storage_controller.search.tooltip_sort_type_name", "Sort by item name.");
        this.add("gui.occultism.storage_controller.search.tooltip_sort_type_mod", "Sort by mod name.");
        this.add("gui.occultism.storage_controller.search.tooltip_sort_direction_down", "Sort ascending.");
        this.add("gui.occultism.storage_controller.search.tooltip_sort_direction_up", "Sort descending.");
        this.add("gui.occultism.storage_controller.search.machines.tooltip@", "Prefix @: Search mod id.");
        this.add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_amount", "Sort by distance.");
        this.add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_name", "Sort by machine name.");
        this.add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_mod", "Sort by mod name.");

    }

    private void addRitualMessages() {
        this.add("ritual.occultism.pentacle_help", "\u00a7lInvalid pentacle!\u00a7r\nWere you trying to create pentacle: %s? Missing:\n%s");
        this.add("ritual.occultism.pentacle_help_at_glue", " at position ");
        this.add("ritual.occultism.pentacle_help.no_pentacle", "\u00a7lNo pentacle found!\u00a7r\nIt seems you did not draw a pentacle, or your pentacle is missing large parts. See the \"Rituals\" section of the Dictionary of Spirits, the required Pentacle will be a clickable blue link above the ritual recipe on the ritual's page.");
        this.add("ritual.occultism.ritual_help", "\u00a7lInvalid ritual!\u00a7r\nWere you trying to perform ritual: \"%s\"? Missing items:\n%s");
        this.add("ritual.occultism.disabled", "This ritual is disabled on this server.");
        this.add("ritual.occultism.does_not_exist", "\u00a7lUnknown ritual\u00a7r. Make sure the pentacle & ingredients are set up correctly. If you are still unsuccessful join our discord at https://discord.gg/trE4SHRXvb");
        this.add("ritual.occultism.book_not_bound", "\u00a7lUnbound Book of Calling\u00a7r. You must craft this book with Dictionary of Spirits to bind to a spirit before starting a ritual.");
        this.add("ritual.occultism.sacrifice", "" + ChatFormatting.WHITE + ChatFormatting.BOLD + "Perform the Sacrifice of:");
        this.add("ritual.occultism.use_item", "" + ChatFormatting.WHITE + ChatFormatting.BOLD + "Use the item:");

        this.add("ritual.occultism.unknown.conditions", "Not all requirements for this ritual are met.");
        this.add("ritual.occultism.unknown.started", "Ritual started.");
        this.add("ritual.occultism.unknown.finished", "Ritual completed successfully.");
        this.add("ritual.occultism.unknown.interrupted", "Ritual interrupted.");

        this.add("ritual.occultism.debug.conditions", "Not all requirements for this ritual are met.");
        this.add("ritual.occultism.debug.started", "Ritual started.");
        this.add("ritual.occultism.debug.finished", "Ritual completed successfully.");
        this.add("ritual.occultism.debug.interrupted", "Ritual interrupted.");
    }

    public void addRitualMessage(DeferredHolder<RitualFactory, RitualFactory> ritual, String key, String message) {
        this.add("ritual.%s.%s".formatted(ritual.getId().getNamespace(), ritual.getId().getPath()) + "." + key, message);
    }


    public void addRitualMessage(DeferredItem<Item> ritualDummy, String key, String message) {
        var ritualName = ritualDummy.getId().getPath().replace("ritual_dummy/", "");
        this.add("ritual.%s.%s".formatted(ritualDummy.getId().getNamespace(), ritualName) + "." + key, message);
    }

    private void addBook() {
        var helper = ModonomiconAPI.get().getContextHelper(Occultism.MODID);
        helper.book("dictionary_of_spirits");

        this.addRitualsCategory(helper);
        this.addSummoningRitualsCategory(helper);
        this.addCraftingRitualsCategory(helper);
        this.addPossessionRitualsCategory(helper);
        this.addFamiliarRitualsCategory(helper);
        this.addStorageCategory(helper);
    }

    private void addRitualsCategory(BookContextHelper helper) {
        helper.category("rituals");
        this.add(helper.categoryName(), "Rituals");

        helper.entry("overview");
        this.add(helper.entryName(), "Rituals");

        helper.page("intro");
        this.add(helper.pageTitle(), "Rituals");
        this.add(helper.pageText(),
                """
                        Rituals allow to summon spirits into our plane of existence, or bind them into objects or living beings. Every ritual consists of a [#](%1$s)Pentacle[#](), [#](%1$s)Ritual Ingredients[#]() provided via sacrificial bowls, a [#](%1$s)Starting Item[#]() and optionally the [#](%1$s)Sacrifice[#]() of living beings. A purple particle effect will show that the ritual is successful and in progress.
                        """.formatted(COLOR_PURPLE));

        helper.page("steps");
        this.add(helper.pageTitle(), "Performing a Ritual");
        this.add(helper.pageText(),
                """
                        Rituals always follow the same steps:
                        - Draw the pentacle.
                        - Place a golden bowl.
                        - Place sacrificial bowls.
                        - Put ingredients in bowls.
                        - [#](%1$s)Right-click[#]()the golden bowl with the activation item.
                        - *Optional: Perform a sacrifice close to the center of the pentacle.*
                        """.formatted(COLOR_PURPLE));

        helper.page("additional_requirements");
        this.add(helper.pageTitle(), "Additional Requirements");
        this.add(helper.pageText(),
                """
                        If a ritual shows grey particles above the golden sacrificial bowl, then additional requirements as described in the ritual's page need to be fulfilled. Once all requirements are fulfilled, the ritual will show purple particles and start to consume the items in the sacrificial bowls.
                        """);

        helper.entry("item_use");
        this.add(helper.entryName(), "Item Use");

        helper.page("intro");
        this.add(helper.pageTitle(), "Item Use");
        this.add(helper.pageText(),
                """
                        Some rituals require the use of certain items to be performed. Use the item described on the ritual's page within **16 blocks** of the [](item://occultism:golden_sacrificial_bowl) to proceed with the ritual.
                        \\
                        \\
                        **Important:** Before using the item, start the ritual. Grey particles indicate that the ritual is ready for the item use.
                        """);

        helper.entry("sacrifice");
        this.add(helper.entryName(), "Sacrifices");

        helper.page("intro");
        this.add(helper.pageTitle(), "Sacrifices");
        this.add(helper.pageText(),
                """
                        Some rituals require the sacrifice of a living being to provide the necessary energy to summon the spirit. Sacrifices are described on the ritual's page under the "Sacrifice" subheading. To perform a sacrifice, kill an animal within 8 blocks of the golden sacrificial bowl. Only kills by players count as sacrifice!
                         """);

        helper.entry("summoning_rituals");
        this.add(helper.entryName(), "Summoning Rituals");

        helper.entry("possession_rituals");
        this.add(helper.entryName(), "Possession Rituals");

        helper.entry("crafting_rituals");
        this.add(helper.entryName(), "Binding Rituals");

        helper.entry("familiar_rituals");
        this.add(helper.entryName(), "Familiar Rituals");
    }

    private void addSummoningRitualsCategory(BookContextHelper helper) {
        helper.category("summoning_rituals");
        this.add(helper.categoryName(), "Summoning Rituals");

        helper.entry("overview");
        this.add(helper.entryName(), "Summoning Rituals");

        helper.page("intro");
        this.add(helper.pageTitle(), "Summoning Rituals");
        this.add(helper.pageText(),
                """
                        Summon rituals force spirits to enter this world in their chosen shape, leading to little restrictions on their power. Summoned spirits range from trade spirits that trade and convert items, to slave-like helpers for manual labour.
                         """);

        helper.entry("return_to_rituals");
        this.add(helper.entryName(), "Return to Rituals Category");

        helper.entry("summon_crusher_t1");
        //Moved to OccultismBookProvider#makeSummonCrusherT1Entry

        helper.entry("summon_crusher_t2");
        this.add(helper.entryName(), "Summon Djinni Crusher");

        helper.page("intro");
        this.add(helper.pageTitle(), "Djinni Crusher");
        this.add(helper.pageText(),
                """
                        The djinni crusher is faster, more efficient and proficient than the foliot crusher.
                        Allowing ice to be crushed without melting.
                        \\
                        It will crush **one** ore into **three** corresponding dusts.
                         """);

        helper.page("ritual");
        //no text

        helper.entry("summon_crusher_t3");
        this.add(helper.entryName(), "Summon Afrit Crusher");

        helper.page("intro");
        this.add(helper.pageTitle(), "Afrit Crusher");
        this.add(helper.pageText(),
                """
                        The afrit crusher is faster and more efficient than the djinni crusher.
                        \\
                        \\
                        It will crush **one** ore into **four** corresponding dusts.
                          """);

        helper.page("ritual");
        //no text

        helper.entry("summon_crusher_t4");
        this.add(helper.entryName(), "Summon Marid Crusher");

        helper.page("intro");
        this.add(helper.pageTitle(), "Marid Crusher");
        this.add(helper.pageText(),
                """
                        The marid crusher is faster, more efficient and proficient than the afrit crusher.
                        Allowing crushing the echo shard while maintaining its properties.
                        \\
                        It will crush **one** ore into **six** corresponding dusts.
                          """);

        helper.page("ritual");
        //no text


        helper.entry("summon_lumberjack");
        //Moved to OccultismBookProvider#makeSummonLumberjackEntry

        helper.entry("summon_transport_items");
        //Moved to OccultismBookProvider#makeSummonTransportItemsEntry


        helper.entry("summon_cleaner");
        //Moved to OccultismBookProvider#makeSummonCleanerEntry

        helper.entry("summon_manage_machine");
        this.add(helper.entryName(), "Summon Djinni Machine Operator");

        helper.page("intro");
        this.add(helper.pageTitle(), "Djinni Machine Operator");
        this.add(helper.pageText(),
                """
                        The machine operator transfers items specified in the dimensional storage actuator GUI, to it's managed machine, and returns crafting results to the storage system. It can also be used to automatically empty a chest into the storage actuator.
                        \\
                        Basically, on-demand crafting!
                          """);

        helper.page("ritual");
        //no text

        helper.page("tutorial");
        this.add(helper.pageText(),
                """
                        To use the machine operator use the book of calling to link a Storage Actuator, the machine and optionally a separate extract location (the face you click on will be extracted from!). For the machine you can additionally set a custom name and the insert/extract facings.
                          """);

        helper.page("tutorial2");
        this.add(helper.pageText(),
                """
                        Please note that setting a new machine (or configuring it with the book of calling) will reset the extraction settings.
                        \\
                        \\
                        For an easy start, make sure to view the short [Tutorial Video](https://gyazo.com/237227ba3775e143463b31bdb1b06f50)!
                          """);

        helper.page("book_of_calling");
        this.add(helper.pageText(),
                """
                        If you lose the book of calling, you can craft a new one.
                        [#](%1$s)Shift-right-click[#]() the spirit with the crafted book to assign it.
                        """.formatted(COLOR_PURPLE));

        helper.entry("trade_spirits");
        this.add(helper.entryName(), "Trade Spirits");

        helper.page("intro");
        this.add(helper.pageTitle(), "Trade Spirits");
        this.add(helper.pageText(),
                """
                        Trade spirits pick up appropriate items and throw trade results on the ground. The spirit is only actively exchanging items if purple particles spawn around it.
                        \\
                        \\
                        **If you do not see any particles**, ensure that you gave the proper item and amount.
                           """);

        helper.page("intro2");
        this.add(helper.pageText(),
                """
                        Most trade spirits experience extreme essence decay and will return to [#](%1$s)The Other Place[#]() quickly.
                           """.formatted(COLOR_PURPLE));

        helper.entry("summon_otherworld_sapling_trader");
        this.add(helper.entryName(), "Summon Otherworld Sapling Trader");

        helper.page("intro");
        this.add(helper.pageTitle(), "Otherworld Sapling Trader");
        this.add(helper.pageText(),
                """
                        Otherworld Trees grown from natural Otherworld Saplings can only be harvested when under the effect of [#](%1$s)Third Eye[#](). To make life easier, the Otherworld Sapling Trader will exchange such natural saplings for a stable variant that can be harvested by anyone, and will drop the same stable saplings when harvested.
                           """.formatted(COLOR_PURPLE));

        helper.page("trade");
        //no text

        helper.page("ritual");
        //no text

        helper.entry("summon_otherstone_trader");
        this.add(helper.entryName(), "Summon Otherstone Trader");

        helper.page("intro");
        this.add(helper.pageTitle(), "Otherstone Trader");
        this.add(helper.pageText(),
                """
                        The Otherstone Trader spirit allows to get more [](item://occultism:otherstone) than using [](item://occultism:spirit_fire). Thus it is especially efficient if you want to use Otherstone as a building material.
                           """);

        helper.page("trade");
        //no text

        helper.page("ritual");
        //no text

        helper.entry("weather_magic");
        this.add(helper.entryName(), "Weather Magic");

        helper.page("intro");
        this.add(helper.pageTitle(), "Weather Magic");
        this.add(helper.pageText(),
                """
                        Weather magic is especially useful for farmers and others depending on specific weather. Summons spirits to modify the weather. Different types of weather modification require different spirits.
                        \\
                        \\
                        Weather spirits will only modify the weather once and then vanish.
                           """);

        helper.page("ritual_clear");
        //no text

        helper.page("ritual_rain");
        //no text

        helper.page("ritual_thunder");
        //no text

        helper.entry("time_magic");
        this.add(helper.entryName(), "Time Magic");

        helper.page("intro");
        this.add(helper.pageTitle(), "Time Magic");
        this.add(helper.pageText(),
                """
                        Time magic is limited in scope, it cannot send the magician back or forth in time, but rather allows to change time time of day. This is especially useful for rituals or other tasks requiring day- or nighttime specifically.
                        \\
                        \\
                        Time spirits will only modify the time once and then vanish.
                           """);

        helper.page("ritual_day");
        //no text

        helper.page("ritual_night");
        //no text

        helper.entry("afrit_essence");
        this.add(helper.entryName(), "Afrit Essence");

        helper.page("intro");
        this.add(helper.pageTitle(), "Afrit Essence");
        this.add(helper.pageText(),
                """
                        [](item://occultism:afrit_essence) is required to safely call on the more powerful spirits, commonly used in the form of red chalk. To obtain the essence, an [#](%1$s)Afrit[#]() needs to be summoned unbound into this plane, and killed. Be warned that this is no simple endeavour, and unbound spirit presents great danger to all nearby.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("marid_essence");
        this.add(helper.entryName(), "Marid Essence");

        helper.page("intro");
        this.add(helper.pageTitle(), "Marid Essence");
        this.add(helper.pageText(),
                """
                        [](item://occultism:marid_essence) is required to safely control the most powerful spirits, commonly used in the form of blue chalk. To obtain the essence, an [#](%1$s)Marid[#]() needs to be summoned unbound into this plane, and killed. Be warned that this is no simple endeavour, and unbound spirit presents great danger to all nearby.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text
    }

    private void addPossessionRitualsCategory(BookContextHelper helper) {
        helper.category("possession_rituals");
        this.add(helper.categoryName(), "Possession Rituals");

        helper.entry("return_to_rituals");
        this.add(helper.entryName(), "Return to Rituals Category");

        helper.entry("overview");
        this.add(helper.entryName(), "Possession Rituals");

        helper.page("intro");
        this.add(helper.pageTitle(), "Possession Rituals");
        this.add(helper.pageText(),
                """
                        Possession rituals bind spirits into living beings, giving the summoner a degree of control over the possessed being.
                        \\
                        \\
                        As such these rituals are used to obtain rare items without having to venture into dangerous places.
                           """);

        helper.entry("possess_enderman");
        this.add(helper.entryName(), "Possessed Enderman");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Drops**: 1-3x [](item://minecraft:ender_pearl)
                                """);

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageText(),
                """
                        In this ritual an [#](%1$s)Enderman[#]() is spawned using the life energy of a [#](%1$s)Pig[#]() and immediately possessed by the summoned [#](%1$s)Djinni[#](). The [#](%1$s)Possessed Enderman[#]() will always drop at least one [](item://minecraft:ender_pearl) when killed.
                                """.formatted(COLOR_PURPLE));

        helper.entry("wither_skull");
        this.add(helper.entryName(), "Wild Hunt");

        helper.page("intro");
        this.add(helper.pageTitle(), "Wither Skeleton Skull");
        this.add(helper.pageText(),
                """
                        Besides venturing into nether dungeons, there is one more way to get these skulls. The legendary [#](%1$s)Wild Hunt[#]() consists of [#](%1$s)Greater Spirits[#]() taking the form of wither skeletons. While summoning the Wild Hunt is incredibly dangerous, it is the fastest way to get wither skeleton skulls.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("possess_endermite");
        this.add(helper.entryName(), "Possessed Endermite");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Drops**: 1-2x [](item://minecraft:end_stone)
                                """);

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageText(),
                """
                        In this ritual an [#](%1$s)Endermite[#]() is tricked into spawning. The stone and dirt represent the surroundings, then an egg is thrown to simulate the use of an ender pearl. When the mite spawns, the summoned [#](%1$s)Foliot[#]() immediately possesses it, visits [#](%1$s)The End[#](), and returns. The [#](%1$s)Possessed Endermite[#]() will always drop at least one [](item://minecraft:end_stone) when killed.
                                """.formatted(COLOR_PURPLE));

        helper.entry("possess_ghast");
        //moved to OccultismBookProvider#makePossessGhastEntry

        helper.entry("possess_skeleton");
        this.add(helper.entryName(), "Possessed Skeleton");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Drops**: 1x [](item://minecraft:skeleton_skull)
                                """);

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageText(),
                """
                        In this ritual an [#](%1$s)Skeleton[#]() is spawned using the life energy of a [#](%1$s)Chicken[#]() and possessed by a [#](%1$s)Foliot[#](). The [#](%1$s)Possessed Skeleton[#]() will be immune to daylight and always drop at least one [](item://minecraft:skeleton_skull) when killed.
                                """.formatted(COLOR_PURPLE));

        helper.entry("possess_unbound_parrot");
        this.add(helper.entryName(), "Unbound Parrot");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: A tameable Parrot
                          """);

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageText(),
                """
                        In this ritual a [#](%1$s)Foliot[#]() is summoned **as an untamed spirit**.
                        \\
                        \\
                        The slaughter of a [#](%1$s)Chicken[#]() and the offering of dyes are intended to entice the Foliot to take the shape of a parrot. As [#](%1$s)Foliot[#]() are not among the smartest spirits, they sometimes misunderstand the instructions ...
                          """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        *This means, if a [#](%1$s)Chicken[#]() is spawned, that's not a bug, just bad luck!*
                           """.formatted(COLOR_PURPLE));

        helper.entry("possess_unbound_otherworld_bird");
        this.add(helper.entryName(), "Unbound Drikwing");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: A tameable Drikwing
                          """);

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageText(),
                """
                        See [Drikwing Familiar](entry://familiar_rituals/familiar_otherworld_bird) for more information.
                          """);
    }

    private void addCraftingRitualsCategory(BookContextHelper helper) {
        helper.category("crafting_rituals");
//        this.add(helper.categoryName(), "Binding Rituals"); //done via the category provider for the rituals category

        helper.entry("return_to_rituals");
        this.add(helper.entryName(), "Return to Rituals Category");

        helper.entry("overview");
        this.add(helper.entryName(), "Binding Rituals");

        helper.page("intro");
        this.add(helper.pageTitle(), "Binding Rituals");
        this.add(helper.pageText(),
                """
                        Binding rituals infuse spirits into items, where their powers are used for one specific purpose. The created items can act like simple empowering enchantments, or fulfill complex tasks to aid the summoner.
                           """);

        helper.entry("craft_storage_system");
        this.add(helper.entryName(), "Magic Storage");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The following entries show only the rituals related to the Magic Storage system. For full step-by-step instructions on building the storage system, see the [Magic Storage](category://storage) category.
                           """.formatted(COLOR_PURPLE));

        helper.entry("craft_dimensional_matrix");
        this.add(helper.entryName(), "Dimensional Matrix");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The dimensional matrix is the entry point to a small dimension used for storing items. A [#](%1$s)Djinni[#]() bound to the matrix keeps the dimension stable, often supported by additional spirits in storage stabilizers, to increase the dimension size.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_infused_pickaxe");
        this.add(helper.entryName(), "Infused Pickaxe");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Otherworld ores usually can only be mined with Otherworld metal tools. The [](item://occultism:infused_pickaxe) is a makeshift solution to this Chicken-and-Egg problem. Brittle spirit attuned gems house a [#](%1$s)Djinni[#]() that allows harvesting the ores, but the durability is extremely low. A more durable version is the [Iesnium Pickaxe](entry://getting_started/iesnium_pickaxe).
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_otherworld_goggles");
        this.add(helper.entryName(), "Craft Otherworld Goggles");

        helper.page("goggles_spotlight");
        this.add(helper.pageText(),
                """
                        The [](item://occultism:otherworld_goggles) give the wearer permanent [#](%1$s)Third Eye[#](), allowing to view even blocks hidden from those partaking of [Demon's Dream](entry://occultism:dictionary_of_spirits/getting_started/demons_dream).
                        \\
                        \\
                        This elegantly solves the general issue of summoners being in a drugged haze, causing all sorts of havoc.
                        """.formatted(COLOR_PURPLE));

        helper.page("goggles_more");
        this.add(helper.pageText(),
                """
                        The Goggles will, however, not give the ability to harvest otherworld materials. That means when wearing goggles, an [Infused Pick](entry://getting_started/infused_pickaxe), or even better, an [Iesnium Pick](entry://getting_started/iesnium_pickaxe) needs to be used to break blocks in order to obtain their Otherworld variants.
                        """.formatted(COLOR_PURPLE));

        helper.page("lenses_spotlight");
        this.add(helper.pageText(),
                """
                        Otherworld Goggles make use of a [#](%1$s)Foliot[#]() bound into the lenses. The Foliot shares it's ability to view higher planes with the wearer, thus allowing them to see Otherworld materials.
                         """.formatted(COLOR_PURPLE));

        helper.page("lenses_more");
        this.add(helper.pageTitle(), "Crafting Lenses");
        this.add(helper.pageText(),
                """
                        Summoning a spirit into the lenses used to craft goggles is one of the first of the more complex rituals apprentice summoners usually attempt, showing that their skills are progressing beyond the basics.
                        """.formatted(COLOR_PURPLE));

        helper.page("lenses_recipe");
        //no text

        helper.page("ritual");
        //no text

        helper.page("goggles_recipe");
        //no text

        helper.entry("craft_storage_controller_base");
        this.add(helper.entryName(), "Storage Actuator Base");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The storage actuator base imprisons a [#](%1$s)Foliot[#]() responsible for interacting with items in a dimensional storage matrix.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_stabilizer_tier1");
        this.add(helper.entryName(), "Storage Stabilizer Tier 1");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        This simple storage stabilizer is inhabited by a [#](%1$s)Foliot[#]() that supports the dimensional matrix in keeping the storage dimension stable, thus allowing to store more items.
                        \\
                        \\
                        By default each Tier 1 Stabilizer adds **64** item types and 512000 items storage capacity.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_stabilizer_tier2");
        this.add(helper.entryName(), "Storage Stabilizer Tier 2");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        This improved stabilizer is inhabited by a [#](%1$s)Djinni[#]() that supports the dimensional matrix in keeping the storage dimension stable, thus allowing to store even more items.
                        \\
                        \\
                        By default each Tier 2 Stabilizer adds **128** item types and 1024000 items storage capacity.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_stabilizer_tier3");
        this.add(helper.entryName(), "Storage Stabilizer Tier 3");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        This advanced stabilizer is inhabited by an [#](%1$s)Afrit[#]() that supports the dimensional matrix in keeping the storage dimension stable, thus allowing to store even more items.
                        \\
                        \\
                        By default each Tier 3 Stabilizer adds **256** item types and 2048000 items storage capacity.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_stabilizer_tier4");
        this.add(helper.entryName(), "Storage Stabilizer Tier 4");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        This highly advanced stabilizer is inhabited by a [#](%1$s)Marid[#]() that supports the dimensional matrix in keeping the storage dimension stable, thus allowing to store even more items.
                        \\
                        \\
                        By default each Tier 4 Stabilizer adds **512** item types and 4098000 items storage capacity.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_stable_wormhole");
        this.add(helper.entryName(), "Stable Wormhole");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The stable wormhole allows access to a dimensional matrix from a remote destination.
                        \\
                        \\
                        Shift-click a [](item://occultism:storage_controller) to link it, then place the wormhole in the world to use it as a remote access point.
                         """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_storage_remote");
        this.add(helper.entryName(), "Remote Storage Accessor");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The [](item://occultism:storage_remote) can be linked to a [](item://occultism:storage_controller) by shift-clicking. The [#](%1$s)Djinni[#]() bound to the accessor will then be able to access items from the actuator even from across dimensions.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_foliot_miner");
        this.add(helper.entryName(), "Foliot Miner");

        helper.page("intro");
        this.add(helper.pageTitle(), "Foliot Miner");
        this.add(helper.pageText(),
                """
                        Miner spirits use [](item://occultism:dimensional_mineshaft) to acquire resources from other dimensions. They are summoned and bound into magic lamps, which they can leave only through the mineshaft. The magic lamp degrades over time, once it breaks the spirit is released back to [#](%1$s)The Other Place[#]().
                        """.formatted(COLOR_PURPLE));

        helper.page("magic_lamp");
        this.add(helper.pageTitle(), "Magic Lamp");
        this.add(helper.pageText(),
                """
                        To summon miner spirits, you first need to craft a [Magic Lamp](entry://getting_started/magic_lamps) to hold them. The key ingredient for that is [Iesnium](entry://getting_started/iesnium).
                        """.formatted(COLOR_PURPLE));

        helper.page("magic_lamp_recipe");
        //no text

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The [#](%1$s)Foliot[#]() miner harvests block without much aim and returns anything it finds. The mining process is quite slow, due to this the Foliot expends only minor amounts of energy, damaging the lamp it is housed in slowly over time.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_djinni_miner");
        this.add(helper.entryName(), "Djinni Miner");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The [#](%1$s)Djinni[#]() miner harvests ores specifically. By discarding other blocks it is able to mine faster and more efficiently. The greater power of the djinni it damages the magic lamp relatively quickly.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_afrit_miner");
        this.add(helper.entryName(), "Afrit Miner");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The [#](%1$s)Afrit[#]() miner harvests ores, like djinni miners, and additionally mines deepslate ores. This miner is faster and more efficient than the djinnis, thus damaging the magic lamp even more slowly.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_marid_miner");
        this.add(helper.entryName(), "Marid Miner");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        The [#](%1$s)Marid[#]() miner is the most powerful miner spirit, it has the fasted mining speed and best magic lamp preservation. Unlike other miner spirits they also can mine the rarest ores, such as [](item://minecraft:ancient_debris) and [](item://occultism:iesnium_ore).
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_ancient_miner");
        this.add(helper.entryName(), "Ancient Miner");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        By compressing MMM you get an extremely powerful miner, but something starts watching you. [](item://occultism:mining_dim_core) are a extremely rarely mined by a Marid.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_satchel");
        this.add(helper.entryName(), "Surprisingly Substantial Satchel");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        A [#](%1$s)Foliot[#]() is bound to the satchel, tasked with **slightly** warping reality. This allows to store more items in the satchel than it's size would indicate, making it a practical traveller's companion.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_soul_gem");
        this.add(helper.entryName(), "Soul Gem");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Soul gems are diamonds set in precious metals, which are then infused with a [#](%1$s)Djinni[#](). The spirit creates a small dimension that allows the temporary entrapment of living beings. Beings of great power or size cannot be stored, however.
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.add(helper.pageTitle(), "Usage");
        this.add(helper.pageText(),
                """
                        To capture an entity, [#](%1$s)right-click[#]() it with the soul gem. \\
                        [#](%1$s)Right-click[#]() again to release the entity.
                        \\
                        \\
                        Bosses cannot be captured.
                               """.formatted(COLOR_PURPLE));


        helper.page("ritual");
        //no text

        helper.entry("craft_familiar_ring");
        this.add(helper.entryName(), "Familiar Ring");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Familiar Rings consist of a [](item://occultism:soul_gem), that contains a [#](%1$s)Djinni[#](), mounted on a ring. The [#](%1$s)Djinni[#]() in the ring allows the familiar captured in the soul gem to apply effects to the wearer."
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.add(helper.pageTitle(), "Usage");
        this.add(helper.pageText(),
                """
                        To use a [](item://occultism:familiar_ring), simply capture a summoned (and tamed) familiar by [#](%1$s)right-clicking[#]() it, and then wear the ring as [#](%1$s)Curio[#]() to make use of the effects the familiar provides.
                        \\
                        \\
                        When released from a familiar ring, the spirit will recognize the person releasing them as their new master.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_wild_trim");
        this.add(helper.entryName(), "Forge Wild Trim");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Unlike other rituals, creating a [](item://minecraft:wild_armor_trim_smithing_template) is a service provided by Wild Spirits and not bound any spirit to the final object. You sacrifice the items and the Wild Spirits uses his power to forge that item for you.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_budding_amethyst");
        this.add(helper.entryName(), "Forge Budding Amethyst");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Unlike other rituals, creating a [](item://minecraft:budding_amethyst) is a service provided by Wild Spirits and not bound any spirit to the final object. You sacrifice the items and the Wild Spirits uses his power to forge that item for you.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_reinforced_deepslate");
        this.add(helper.entryName(), "Forge Reinforced Deepslate");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Unlike other rituals, creating a [](item://minecraft:reinforced_deepslate) is a service provided by Wild Spirits and not bound any spirit to the final object. You sacrifice the items and the Wild Spirits uses his power to forge that item for you.\\
                        \\
                        These blocks can be collected with a infused or iesnium pickaxe.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("repair");
        this.add(helper.entryName(), "Repair Rituals");

        helper.page("spotlight");
        this.add(helper.pageTitle(), "Repairing");
        this.add(helper.pageText(),
                """
                        With simple materials, a Djinni can repair any chalk for you. By evolving in the occult path, an Afrit can repair miners, tools and armors. Any item repaired in this way retains its properties.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual_chalks");
        //no text
        helper.page("ritual_miners");
        //no text
        helper.page("ritual_tools");
        //no text
        helper.page("ritual_armors");
        //no text
    }

    private void addFamiliarRitualsCategory(BookContextHelper helper) {
        helper.category("familiar_rituals");

        helper.entry("return_to_rituals");
        this.add(helper.entryName(), "Return to Rituals Category");

        helper.entry("overview");
        this.add(helper.entryName(), "Familiar Rituals");

        helper.page("intro");
        this.add(helper.pageTitle(), "Familiar Rituals");
        this.add(helper.pageText(),
                """
                        Familiar rituals summon spirits to aid the summoner directly. The spirits usually inhabit an animal's body, allowing them to resist essence decay. Familiars provide buffs, but may also actively protect the summoner.
                                """.formatted(COLOR_PURPLE));

        helper.page("ring");
        this.add(helper.pageTitle(), "Equipping Familiars");
        this.add(helper.pageText(),
                """
                        Enterprising summoners have found a way to bind familiars into jewelry that passively applies their buff, the [Familiar Ring](entry://crafting_rituals/craft_familiar_ring).
                                """.formatted(COLOR_PURPLE));

        helper.page("trading");
        this.add(helper.pageTitle(), "Equipping Familiars");
        this.add(helper.pageText(),
                """
                        "Familiars can be easily traded when in a [Familiar Ring](entry://crafting_rituals/craft_familiar_ring).
                        \\
                        \\
                        When released, the spirit will recognize the person releasing them as their new master.
                                 """.formatted(COLOR_PURPLE));

        helper.entry("familiar_bat");
        this.add(helper.entryName(), "Bat Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Night Vision[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, the bat familiar will give a life steal effect to it's master.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_beaver");
        this.add(helper.entryName(), "Beaver Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Increased wood break speed[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The Beaver familiar will chop down nearby trees when they grow from a sapling into a tree. It can only handle small trees.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        Gives free snacks when right-clicked with an empty hand.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_beholder");
        this.add(helper.entryName(), "Beholder Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Highlights enemies[#](), [#](%1$s)Shoots **FREAKING LAZORS**[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The Beholder familiar highlights nearby entities with a glow effect, and shoots laser rays at enemies. It **eats** (poor) **Shub Niggurath babies** to gain temporary damage and speed.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it give it's master immunity to blindness, and after highlighting a Warden, the immunity extends to darkness.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_blacksmith");
        this.add(helper.entryName(), "Blacksmith Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Repairs Equipment while Mining[#](), [#](%1$s)Upgrades other familiars[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        Whenever the player picks up stone, there is a chance for the blacksmith familiar to repair their equipment a little bit.
                        \\
                        \\
                        **Upgrade Behaviour**: \\
                        Cannot be upgraded, but upgrades other Familiars.
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageTitle(), "Upgrading Familiars");
        this.add(helper.pageText(),
                """
                        To upgrade other familiars the blacksmith needs to be given iron ingots or blocks by [#](%1$s)right-clicking[#]() it.
                        \\
                        \\
                        Upgraded familiars provide additional effects.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_chimera");
        this.add(helper.entryName(), "Chimera Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Rideable Mount[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The chimera familiar can be fed (any) meat to grow, when growing it will gain damage and speed. Once it has grown big enough, players can ride it. When feeding it a [](item://minecraft:golden_apple) the [#](%1$s)Goat[#]() will detach and become a separate familiar.
                        \\
                        \\
                        The detached goat familiar can be used to obtain the [Shub Niggurath](entry://familiar_rituals/familiar_shub_niggurath) familiar.
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, the goat familiar will get a warning bell. When you hit the familiar it will ring the bell and attract enemies in a large radius.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_cthulhu");
        this.add(helper.entryName(), "Cthulhu Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Water Breathing[#](), [#](%1$s)General Coolness[#]()
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it will act as a mobile light source.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_shub_niggurath");
        this.add(helper.entryName(), "Shub Niggurath Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Spawns small versions of itself to fight for you.[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        this.add(helper.pageTitle(), "Ritual");
        this.add(helper.pageText(),
                """
                        The [#](%1$s)Shub Niggurath[#]() is not summoned directly. First, summon a [Chimera Familiar](entry://familiar_rituals/familiar_chimera) and feed it a [](item://minecraft:golden_apple) to detach the [#](%1$s)Goat[#](). Bring the goat to a [#](%1$s)Forest Biome[#](). Then click the goat with [any Black Dye](item://minecraft:black_dye), [](item://minecraft:flint) and [](item://minecraft:ender_eye) to summon the [#](%1$s)Shub Niggurath[#]().
                           """.formatted(COLOR_PURPLE));

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it will get a warning bell. When you hit the familiar it will ring the bell and **attract enemies** in a large radius.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_deer");
        this.add(helper.entryName(), "Deer Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Speed and Jump Boost, Step assist[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, will increase the step assist and it will attack nearby enemies with a hammer. Yep, a **hammer**.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_devil");
        this.add(helper.entryName(), "Devil Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Fire Resistance[#](), [#](%1$s)Attacks Enemies[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        Enchants a Golden Apple when right-click, but has large time interval.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_dragon");
        this.add(helper.entryName(), "Dragon Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Increased XP[#](), Loves Sticks
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        Greedy familiars can ride on dragon familiars, giving the dragon the greedy effects additionally.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it will throw swords at nearby enemies.
                           """.formatted(COLOR_PURPLE));


        helper.entry("familiar_fairy");
        this.add(helper.entryName(), "Fairy Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Assists Familiars[#](), [#](%1$s)Prevents Familiar Deaths[#](), [#](%1$s)Drains Enemy Life Force[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The Fairy familiar **keeps other familiars from dying** (with cooldown), helps out other familiars with **beneficial effects** and **drains the life force of enemies** to assist their master.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        Allow getting Dragon's Breath when right-clicked with a glass bottle.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_greedy");
        this.add(helper.entryName(), "Greedy Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Picks up Items[#](), [#](%1$s)Increased Pick-up Range[#]()
                                   """.formatted(COLOR_PURPLE));
        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The greedy familiar is a Foliot that will pick up nearby items for it's master. When captured in a familiar ring it increased the pick-up range of the wearer.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it can find blocks for its master. [#](%1$s)Right-click[#]() it with a block to tell it what to look for.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_guardian");
        this.add(helper.entryName(), "Guardian Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Prevents player death while alive[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The guardian familiar sacrifices a limb everytime it's master is about to die and thus **prevents the death**. Once the guardian dies, the player is no longer protected. When summoned, the guardian spawns with a **random amount of limbs**, there is no guarantee that a complete guardian is summoned.
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it regains a limb.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_headless");
        this.add(helper.entryName(), "Headless Ratman Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Conditional Damage Buff[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The headless ratman familiar steals heads of mobs near the ratman when they are killed. It then provides a damage buff against that type of mob to their master. If the ratman drops **below 50%% health** it dies, but can then be rebuilt by their master by giving them [](item://minecraft:wheat), [](item://minecraft:stick), [](item://minecraft:hay_block) and a [](item://minecraft:carved_pumpkin).
                           """);

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it will give weakness to nearby mobs of the type it stole the head from. And the owner will not make the Enderman angry by looking into his eyes.
                           """.formatted(COLOR_PURPLE));


        helper.entry("familiar_mummy");
        this.add(helper.entryName(), "Mummy Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Fights your enemies[#](), [#](%1$s)Dodge Effect[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        The Mummy familiar is a martial arts expert and fights to protect their master.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        When upgraded by a blacksmith familiar, it the familiar will deal even more damage and double the dodge chance.
                            """.formatted(COLOR_PURPLE));

        helper.entry("familiar_otherworld_bird");
        this.add(helper.entryName(), "Drikwing Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Multi-Jump[#](), [#](%1$s)Jump Boost[#](), [#](%1$s)Slow Falling[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        [#](%1$s)Drikwings[#]() are a subclass of [#](%1$s)Djinni[#]() that are known to be amicable towards humans. They usually take the shape of a dark blue and purple parrot. Drikwings will provide their owner with limited flight abilities when nearby.
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        Increase number of jumps and change the slow fall to immunity to fall damage.
                            """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        To obtain the parrot or parrot familiar for the sacrifice, consider summoning them using either the [Wild Parrot Ritual](entry://possession_rituals/possess_unbound_parrot) or [Parrot Familiar Ritual](entry://familiar_rituals/familiar_parrot)
                        \\
                        \\
                        **Hint:** If you use mods that protect pets from death, use the wild parrot ritual!
                            """.formatted(COLOR_PURPLE));

        helper.entry("familiar_parrot");
        this.add(helper.entryName(), "Parrot Familiar");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: [#](%1$s)Company[#]()
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text


        //
        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        In this ritual a [#](%1$s)Foliot[#]() is summoned **as a familiar**, the slaughter of a [#](%1$s)Chicken[#]() and the offering of dyes are intended to entice the [#](%1$s)Foliot[#]() to take the shape of a parrot.\\
                        As [#](%1$s)Foliot[#]() are not among the smartest spirits, they sometimes misunderstand the instructions ...
                            """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.add(helper.pageText(),
                """
                        *This means, if a [#](%1$s)Chicken[#]() is spawned, that's not a bug, just bad luck!*
                        \\
                        \\
                        **Upgrade Behaviour**\\
                        Cannot be upgraded by the blacksmith familiar.
                           """.formatted(COLOR_PURPLE));
        //no text

        helper.entry("resurrect_allay");
        this.add(helper.entryName(), "Purify Vex to Allay");

        helper.page("entity");
        this.add(helper.pageText(),
                """
                        **Provides**: Allay
                          """);

        helper.page("ritual");

        helper.page("description");
        this.add(helper.pageTitle(), "Description");
        this.add(helper.pageText(),
                """
                        Purify a Vex to an Allay on a resurrection process that reveals its true name.
                          """.formatted(COLOR_PURPLE));

    }

    private void addStorageCategory(BookContextHelper helper) {
        helper.category("storage");
        this.add(helper.categoryName(), "Magic Storage");

        helper.entry("overview");
        this.add(helper.entryName(), "Magic Storage");

        helper.page("intro");
        this.add(helper.pageTitle(), "Magic Storage");
        this.add(helper.pageText(),
                """
                        Every summoner knows the problem: There are just too many occult paraphernalia lying around. The solution is simple, yet elegant: Magic Storage!
                        \\
                        \\
                        Using Spirits able to access storage dimensions it is possible to create almost unlimited storage space.
                        """.formatted(COLOR_PURPLE));

        helper.page("intro2");
        this.add(helper.pageText(),
                """
                        Follow the steps shown in this category to get your own storage system!
                        The steps related to storage in [Binding Rituals](category://crafting_rituals/) show only the rituals, while here **all required steps** including crafting are shown.
                        """.formatted(COLOR_PURPLE));

        helper.entry("storage_controller");
        this.add(helper.entryName(), "Storage Actuator");

        helper.page("intro");
        this.add(helper.pageTitle(), "Storage Actuator");
        this.add(helper.pageText(),
                """
                        The [](item://occultism:storage_controller) consists of a [Dimensional Matrix](entry://crafting_rituals/craft_dimensional_matrix) inhabited by a [#](%1$s)Djinni[#]() that creates and manages a storage dimension, and a [Base](entry://crafting_rituals/craft_storage_controller_base) infused with a [#](%1$s)Foliot[#]() that moves items in and out of the storage dimension.
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.add(helper.pageTitle(), "Usage");
        this.add(helper.pageText(),
                """
                        After crafting the [](item://occultism:storage_controller) (see following pages), place it in the world and [#](%1$s)right-click[#]() it with an empty hand. This will open the GUI of the storage controller, from there on it will work much like a very big shulker box.
                        """.formatted(COLOR_PURPLE));

        helper.page("safety");
        this.add(helper.pageTitle(), "Safety first!");
        this.add(helper.pageText(),
                """
                        Breaking the storage controller will store all contained items in the dropped item, you will not lose anything.
                        The same applies to breaking or replacing Storage Stabilizers (you will learn about these later). 
                        \\
                        \\
                        Like in a shulker box, your items are safe!
                        """.formatted(COLOR_PURPLE));


        helper.page("size");
        this.add(helper.pageTitle(), "So much storage!");
        this.add(helper.pageText(),
                """
                        The storage controller holds up to **128** different types of items (_You will learn later how to increase that_). Additionally it is limited to 256000 items in total. It does not matter if you have 256000 different items or 256000 of one item, or any mix.
                        """.formatted(COLOR_PURPLE));

        helper.page("unique_items");
        this.add(helper.pageTitle(), "Unique Items");
        this.add(helper.pageText(),
                """
                        Items with unique properties ("NBT data"), such as damaged or enchanted equipment will take up one item type for each variation. For example two wooden swords with two different damage values take up two item types. Two wooden swords with the same (or no) damage take up one item type.
                        """.formatted(COLOR_PURPLE));

        helper.page("config");
        this.add(helper.pageTitle(), "Configurablity");
        this.add(helper.pageText(),
                """
                        The item type amount and storage size can be configured in the "[#](%1$s)occultism-server.toml[#]()" config file in the save directory of your world.
                        """.formatted(COLOR_PURPLE));

        helper.page("mods");
        this.add(helper.pageTitle(), "Interaction with Mods");
        this.add(helper.pageText(),
                """
                        For other mods the storage controller behaves like a shulker box, anything that can interact with vanilla chests and shulker boxes can interact with the storage controller.
                        Devices that count storage contents may have trouble with the stack sizes.
                        """.formatted(COLOR_PURPLE));


        helper.page("matrix_ritual");
        //no text

        helper.page("base_ritual");
        //no text

        helper.page("recipe");
        this.add(helper.pageText(),
                """
                        This is the actual block that works as a storage, make sure to craft it!
                        Placing just the [](item://occultism:storage_controller_base) from the previous step won't work.
                        """.formatted(COLOR_PURPLE));
        //no text


        helper.entry("storage_stabilizer");
        this.add(helper.entryName(), "Extending Storage");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Storage Stabilizers increase the storage space in the storage dimension of the storage actuator. The higher the tier of the stabilizer, the more additional storage it provides. The following entries will show you how to craft each tier.
                        \\
                        \\
                        """.formatted(COLOR_PURPLE));

        helper.page("upgrade");
        this.add(helper.pageTitle(), "Upgrading");
        this.add(helper.pageText(),
                """
                        It is **safe to destroy a storage stabilizer** to upgrade it. The items in the [Storage Actuator](entry://storage/storage_controller) will not be lost or dropped - you simply cannot add new items until you add enough storage stabilizers to have free slots again.
                         """.formatted(COLOR_PURPLE));

        helper.page("build_instructions");
        this.add(helper.pageTitle(), "Build Instructions");
        this.add(helper.pageText(),
                """
                        Storage controllers need to point at the [Dimensional Matrix](entry://crafting_rituals/craft_dimensional_matrix), that means **one block above the [Storage Actuator](entry://storage/storage_controller)**.
                        \\
                        \\
                        They can be **up to 5 blocks away** from the Dimensional Matrix, and need to be in a straight line of sight. See the next page for a possible very simple setup.
                        """.formatted(COLOR_PURPLE));


        helper.page("demo");
        this.add(helper.pageTitle(), "Storage Stabilizer Setup");
        this.add(helper.pageText(),
                """
                        **Note:** You do not need all 4 stabilizers, even one will increase your storage.
                        """.formatted(COLOR_PURPLE));
    }

    private void addAdvancements() {
        //"advancements\.occultism\.(.*?)\.title": "(.*)",
        //this.advancementTitle\("\1", "\2"\);
        this.advancementTitle("root", "Occultism");
        this.advancementDescr("root", "Get Spiritual!");
        this.advancementTitle("summon_foliot_crusher", "Ore Doubling");
        this.advancementDescr("summon_foliot_crusher", "Crunch! Crunch! Crunch!");
        this.advancementTitle("familiars", "Occultism: Friends");
        this.advancementDescr("familiars", "Use a ritual to summon a familiar");
        this.advancementDescr("familiar.bat", "Lure a normal bat near your bat familiar");
        this.advancementTitle("familiar.bat", "Cannibalism");
        this.advancementDescr("familiar.capture", "Trap your familiar in a familiar ring");
        this.advancementTitle("familiar.capture", "Catch them all!");
        this.advancementDescr("familiar.cthulhu", "Make your cthulhu familiar sad");
        this.advancementTitle("familiar.cthulhu", "You Monster!");
        this.advancementDescr("familiar.deer", "Observe when your deer familiar poops demon seed");
        this.advancementTitle("familiar.deer", "Demonic Poop");
        this.advancementDescr("familiar.devil", "Command your devil familiar to breath fire");
        this.advancementTitle("familiar.devil", "Hellfire");
        this.advancementDescr("familiar.dragon_nugget", "Give a gold nugget to your dragon familiar");
        this.advancementTitle("familiar.dragon_nugget", "Deal!");
        this.advancementDescr("familiar.dragon_ride", "Let your greedy familiar pick something up while riding a dragon familiar");
        this.advancementTitle("familiar.dragon_ride", "Working together");
        this.advancementDescr("familiar.greedy", "Let your greedy familiar pick something up for you");
        this.advancementTitle("familiar.greedy", "Errand Boy");
        this.advancementDescr("familiar.party", "Get your familiar to dance");
        this.advancementTitle("familiar.party", "Dance!");
        this.advancementDescr("familiar.rare", "Obtain a rare familiar variant");
        this.advancementTitle("familiar.rare", "Rare Friend");
        this.advancementDescr("familiar.root", "Use a ritual to summon a familiar");
        this.advancementTitle("familiar.root", "Occultism: Friends");
        this.advancementDescr("familiar.mans_best_friend", "Pet your dragon familiar; and play fetch with it");
        this.advancementTitle("familiar.mans_best_friend", "Man's Best Friend");
        this.advancementTitle("familiar.blacksmith_upgrade", "Fully Equipped!");
        this.advancementDescr("familiar.blacksmith_upgrade", "Let your blacksmith familiar upgrade one of your other familiars");
        this.advancementTitle("familiar.guardian_ultimate_sacrifice", "The Ultimate Sacrifice");
        this.advancementDescr("familiar.guardian_ultimate_sacrifice", "Let your Guardian Familiar die to save yourself");
        this.advancementTitle("familiar.headless_cthulhu_head", "The Horror!");
        this.advancementDescr("familiar.headless_cthulhu_head", "Kill Cthulhu near your Headless Ratman familiar");
        this.advancementTitle("familiar.headless_rebuilt", "We can rebuild him");
        this.advancementDescr("familiar.headless_rebuilt", "\"Rebuild\" your Headless Ratman familiar after he has died");
        this.advancementTitle("familiar.chimera_ride", "Mount up!");
        this.advancementDescr("familiar.chimera_ride", "Ride on your Chimera familiar when you have fed it enough");
        this.advancementTitle("familiar.goat_detach", "Disassemble");
        this.advancementDescr("familiar.goat_detach", "Give your Chimera familiar a golden apple");
        this.advancementTitle("familiar.shub_niggurath_summon", "The Black Goat of the Woods");
        this.advancementDescr("familiar.shub_niggurath_summon", "Transform your goat familiar into something terrible");
        this.advancementTitle("familiar.shub_cthulhu_friends", "Eldritch Love");
        this.advancementDescr("familiar.shub_cthulhu_friends", "Watch Shub Niggurath and Cthulhu hold hands");
        this.advancementTitle("familiar.shub_niggurath_spawn", "Think of the Children!");
        this.advancementDescr("familiar.shub_niggurath_spawn", "Let a spawn of Shub Niggurath damage an enemy by exploding");
        this.advancementTitle("familiar.beholder_ray", "Death Ray");
        this.advancementDescr("familiar.beholder_ray", "Let your Beholder familiar attack an enemy");
        this.advancementTitle("familiar.beholder_eat", "Hunger");
        this.advancementDescr("familiar.beholder_eat", "Watch your Beholder familiar eat a spawn of Shub Niggurath");
        this.advancementTitle("familiar.fairy_save", "Guardian Angel");
        this.advancementDescr("familiar.fairy_save", "Let your Fairy familiar save one of your other familiars from certain death");
        this.advancementTitle("familiar.mummy_dodge", "Ninja!");
        this.advancementDescr("familiar.mummy_dodge", "Dodge an attack with the Mummy familiar dodge effect");
        this.advancementTitle("familiar.beaver_woodchop", "Woodchopper");
        this.advancementDescr("familiar.beaver_woodchop", "Let your Beaver familiar chop down a tree");
        this.advancementTitle("chalks.root", "Occultism: Chalks");
        this.advancementDescr("chalks.root", "Colorful");
        this.advancementTitle("chalks.white", "Use the White Chalk");
        this.advancementDescr("chalks.white", "First Foundation");
        this.advancementTitle("chalks.light_gray", "Use the Light Gray Chalk");
        this.advancementDescr("chalks.light_gray", "Second Foundation");
        this.advancementTitle("chalks.gray", "Use the Gray Chalk");
        this.advancementDescr("chalks.gray", "Third Foundation");
        this.advancementTitle("chalks.black", "Use the Black Chalk");
        this.advancementDescr("chalks.black", "Fourth Foundation");
        this.advancementTitle("chalks.brown", "Use the Brown Chalk");
        this.advancementDescr("chalks.brown", "Bait for what?");
        this.advancementTitle("chalks.red", "Use the Red Chalk");
        this.advancementDescr("chalks.red", "Third Tier!");
        this.advancementTitle("chalks.orange", "Use the Orange Chalk");
        this.advancementDescr("chalks.orange", "Third Tier?");
        this.advancementTitle("chalks.yellow", "Use the Yellow Chalk");
        this.advancementDescr("chalks.yellow", "Possession");
        this.advancementTitle("chalks.lime", "Use the Lime Chalk");
        this.advancementDescr("chalks.lime", "Second Tier");
        this.advancementTitle("chalks.green", "Use the Green Chalk");
        this.advancementDescr("chalks.green", "Wild Attraction");
        this.advancementTitle("chalks.cyan", "Use the Cyan Chalk");
        this.advancementDescr("chalks.cyan", "Ancient Knowledge");
        this.advancementTitle("chalks.light_blue", "Use the Light Blue Chalk");
        this.advancementDescr("chalks.light_blue", "Wild Stabilizer");
        this.advancementTitle("chalks.blue", "Use the Blue Chalk");
        this.advancementDescr("chalks.blue", "Fourth Tier");
        this.advancementTitle("chalks.purple", "Use the Purple Chalk");
        this.advancementDescr("chalks.purple", "Infusion");
        this.advancementTitle("chalks.magenta", "Use the Magenta Chalk");
        this.advancementDescr("chalks.magenta", "Dragon Power");
        this.advancementTitle("chalks.pink", "Use the Pink Chalk");
        this.advancementDescr("chalks.pink", "Wild Power");
        this.advancementTitle("chalks.rainbow", "Use the Rainbow Chalk");
        this.advancementDescr("chalks.rainbow", "Why Many Chalks?");
        this.advancementTitle("chalks.void", "Use the Void Chalk");
        this.advancementDescr("chalks.void", "...");
    }

    private void addKeybinds() {
        this.add("key.occultism.category", "Occultism");
        this.add("key.occultism.backpack", "Open Satchel");
        this.add("key.occultism.storage_remote", "Open Storage Accessor");
        this.add("key.occultism.familiar.otherworld_bird", "Toggle Ring Effect: Drikwing");
        this.add("key.occultism.familiar.greedy_familiar", "Toggle Ring Effect: Greedy");
        this.add("key.occultism.familiar.bat_familiar", "Toggle Ring Effect: Bat");
        this.add("key.occultism.familiar.deer_familiar", "Toggle Ring Effect: Deer");
        this.add("key.occultism.familiar.cthulhu_familiar", "Toggle Ring Effect: Cthulhu");
        this.add("key.occultism.familiar.devil_familiar", "Toggle Ring Effect: Devil");
        this.add("key.occultism.familiar.dragon_familiar", "Toggle Ring Effect: Dragon");
        this.add("key.occultism.familiar.blacksmith_familiar", "Toggle Ring Effect: Blacksmith");
        this.add("key.occultism.familiar.guardian_familiar", "Toggle Ring Effect: Guardian");
        this.add("key.occultism.familiar.headless_familiar", "Toggle Ring Effect: Headless Ratman");
        this.add("key.occultism.familiar.chimera_familiar", "Toggle Ring Effect: Chimera");
        this.add("key.occultism.familiar.goat_familiar", "Toggle Ring Effect: Goat");
        this.add("key.occultism.familiar.shub_niggurath_familiar", "Toggle Ring Effect: Shub Niggurath");
        this.add("key.occultism.familiar.beholder_familiar", "Toggle Ring Effect: Beholder");
        this.add("key.occultism.familiar.fairy_familiar", "Toggle Ring Effect: Fairy");
        this.add("key.occultism.familiar.mummy_familiar", "Toggle Ring Effect: Mummy");
        this.add("key.occultism.familiar.beaver_familiar", "Toggle Ring Effect: Beaver");
    }

    private void addJeiTranslations() {
        this.add("occultism.jei.spirit_fire", "Spiritfire");
        this.add("occultism.jei.crushing", "Crusher Spirit");
        this.add("occultism.jei.miner", "Dimensional Mineshaft");
        this.add("occultism.jei.miner.chance", "Weight: %d");
        this.add("occultism.jei.ritual", "Occult Ritual");
        this.add("occultism.jei.pentacle", "Pentacle");

        this.add(TranslationKeys.JEI_CRUSHING_RECIPE_MIN_TIER, "Min Crusher Tier: %d");
        this.add(TranslationKeys.JEI_CRUSHING_RECIPE_MAX_TIER, "Max Crusher Tier: %d");
        this.add("jei.occultism.ingredient.tallow.description", "Kill animals, such as \u00a72pigs\u00a7r, \u00a72cows\u00a7r, \u00a72sheep\u00a7r, \u00a72horses\u00a7r and \u00a72lamas\u00a7r with the Butcher Knife to obtain tallow.");
        this.add("jei.occultism.ingredient.otherstone.description", "Primarily found in Otherworld Groves. Only visible while the status \u00a76Third Eye\u00a7r is active. See \u00a76Dictionary of Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.otherworld_log.description", "Primarily found in Otherworld Groves. Only visible while the status \u00a76Third Eye\u00a7r is active. See \u00a76Dictionary of Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.otherworld_sapling.description", "Can be obtained from a Otherworld Sapling Trader. Can be seen and harvested without \u00a76Third Eye\u00a7r. See \u00a76Dictionary of Spirits\u00a7r for information on how to summon the trader.");
        this.add("jei.occultism.ingredient.otherworld_sapling_natural.description", "Primarily found in Otherworld Groves. Only visible while the status \u00a76Third Eye\u00a7r is active. See \u00a76Dictionary of Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.otherworld_leaves.description", "Primarily found in Otherworld Groves. Only visible while the status \u00a76Third Eye\u00a7r is active. See \u00a76Dictionary of Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.iesnium_ore.description", "Found in the nether. Only visible while the status \u00a76Third\u00a7r \u00a76Eye\u00a7r is active. See \u00a76Dictionary\u00a7r \u00a76of\u00a7r \u00a76Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.spirit_fire.description", "Throw \u00a76Demon's Dream  Fruit\u00a7r to the ground and light it on fire. See \u00a76Dictionary of Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.datura.description", "Can be used to heal all spirits and familiars summoned by Occultism Rituals. Simply right-click the entity to heal it by one heart");

        this.add("jei.occultism.ingredient.spawn_egg.familiar_goat.description", "The Goat Familiar can be obtained by feeding a Golden Apple to a Chimera Familiar. See \u00a76Dictionary\u00a7r \u00a76of\u00a7r \u00a76Spirits\u00a7r for more information.");
        this.add("jei.occultism.ingredient.spawn_egg.familiar_shub_niggurath.description", "The Shub Niggurath Familiar can be obtained by bringing a Goat Familiar to a Forest Biome and clicking the Goat first with any Black Dye, then Flint and then an Eye of Ender. See \u00a76Dictionary\u00a7r \u00a76of\u00a7r \u00a76Spirits\u00a7r for more information.");

        this.add("jei.occultism.sacrifice", "Sacrifice: %s");
        this.add("jei.occultism.summon", "Summon: %s");
        this.add("jei.occultism.job", "Job: %s");
        this.add("jei.occultism.item_to_use", "Item to use:");
        this.add("jei.occultism.error.missing_id", "Cannot identify recipe.");
        this.add("jei.occultism.error.invalid_type", "Invalid recipe type.");
        this.add("jei.occultism.error.recipe_too_large", "Recipe larger than 3x3.");
        this.add("jei.occultism.error.recipe_items_missing", "Missing items will be skipped.");
        this.add("jei.occultism.error.recipe_no_items", "No compatible items fround for recipe.");
        this.add("jei.occultism.error.recipe_move_items", "Move items");
        this.add("jei.occultism.error.pentacle_not_loaded", "The pentacle could not be loaded.");
        this.add("item.occultism.jei_dummy.require_sacrifice", "Requires Sacrifice!");
        this.add("item.occultism.jei_dummy.require_sacrifice.tooltip", "This ritual requires a sacrifice to start. Please refer to the Dictionary of Spirits for detailed instructions.");
        this.add("item.occultism.jei_dummy.require_item_use", "Requires Item Use!");
        this.add("item.occultism.jei_dummy.require_item_use.tooltip", "This ritual requires to use a specific item to start. Please refer to the Dictionary of Spirits for detailed instructions.");
        this.add("item.occultism.jei_dummy.none", "Non-Item Ritual Result");
        this.add("item.occultism.jei_dummy.none.tooltip", "This ritual does not create any items.");
    }

    private void addFamiliarSettingsMessages() {
        this.add("message.occultism.familiar.otherworld_bird.enabled", "Ring Effect - Drikwing: Enabled");
        this.add("message.occultism.familiar.otherworld_bird.disabled", "Ring Effect - Drikwing: Disabled");
        this.add("message.occultism.familiar.greedy_familiar.enabled", "Ring Effect - Greedy: Enabled");
        this.add("message.occultism.familiar.greedy_familiar.disabled", "Ring Effect - Greedy: Disabled");
        this.add("message.occultism.familiar.bat_familiar.enabled", "Ring Effect - Bat: Enabled");
        this.add("message.occultism.familiar.bat_familiar.disabled", "Ring Effect - Bat: Disabled");
        this.add("message.occultism.familiar.deer_familiar.enabled", "Ring Effect - Deer: Enabled");
        this.add("message.occultism.familiar.deer_familiar.disabled", "Ring Effect - Deer: Disabled");
        this.add("message.occultism.familiar.cthulhu_familiar.enabled", "Ring Effect - Cthulhu: Enabled");
        this.add("message.occultism.familiar.cthulhu_familiar.disabled", "Ring Effect - Cthulhu: Disabled");
        this.add("message.occultism.familiar.devil_familiar.enabled", "Ring Effect - Devil: Enabled");
        this.add("message.occultism.familiar.devil_familiar.disabled", "Ring Effect - Devil: Disabled");
        this.add("message.occultism.familiar.dragon_familiar.enabled", "Ring Effect - Dragon: Enabled");
        this.add("message.occultism.familiar.dragon_familiar.disabled", "Ring Effect - Dragon: Disabled");
        this.add("message.occultism.familiar.blacksmith_familiar.enabled", "Ring Effect - Blacksmith: Enabled");
        this.add("message.occultism.familiar.blacksmith_familiar.disabled", "Ring Effect - Blacksmith: Disabled");
        this.add("message.occultism.familiar.guardian_familiar.enabled", "Ring Effect - Guardian: Enabled");
        this.add("message.occultism.familiar.guardian_familiar.disabled", "Ring Effect - Guardian: Disabled");
        this.add("message.occultism.familiar.headless_familiar.enabled", "Ring Effect - Headless Ratman: Enabled");
        this.add("message.occultism.familiar.headless_familiar.disabled", "Ring Effect - Headless Ratman: Disabled");
        this.add("message.occultism.familiar.chimera_familiar.enabled", "Ring Effect - Chimera: Enabled");
        this.add("message.occultism.familiar.chimera_familiar.disabled", "Ring Effect - Chimera: Disabled");
        this.add("message.occultism.familiar.shub_niggurath_familiar.enabled", "Ring Effect - Shub Niggurath: Enabled");
        this.add("message.occultism.familiar.shub_niggurath_familiar.disabled", "Ring Effect - Shub Niggurath: Disabled");
        this.add("message.occultism.familiar.beholder_familiar.enabled", "Ring Effect - Beholder: Enabled");
        this.add("message.occultism.familiar.beholder_familiar.disabled", "Ring Effect - Beholder: Disabled");
        this.add("message.occultism.familiar.fairy_familiar.enabled", "Ring Effect - Fairy: Enabled");
        this.add("message.occultism.familiar.fairy_familiar.disabled", "Ring Effect - Fairy: Disabled");
        this.add("message.occultism.familiar.mummy_familiar.enabled", "Ring Effect - Mummy: Enabled");
        this.add("message.occultism.familiar.mummy_familiar.disabled", "Ring Effect - Mummy: Disabled");
        this.add("message.occultism.familiar.beaver_familiar.enabled", "Ring Effect - Beaver: Enabled");
        this.add("message.occultism.familiar.beaver_familiar.disabled", "Ring Effect - Beaver: Disabled");
    }

    private void addPentacles() {
        this.addPentacle("otherworld_bird", "Otherworld Bird");
        this.addPentacle("summon_foliot", "Aviar's Circle");
        this.addPentacle("summon_djinni", "Ophyx' Calling");
        this.addPentacle("summon_unbound_afrit", "Abras' Open Conjure");
        this.addPentacle("summon_afrit", "Abras' Conjure");
        this.addPentacle("summon_unbound_marid", "Abras' Fortified Conjure");
        this.addPentacle("summon_marid", "Fatma's Incentivized Attraction");
        this.addPentacle("possess_foliot", "Hedyrin's Lure");
        this.addPentacle("possess_djinni", "Ihagan's Enthrallment");
        this.addPentacle("possess_unbound_afrit", "Abras' Open Commanding Conjure");
        this.addPentacle("possess_afrit", "Abras' Commanding Conjure");
        this.addPentacle("possess_marid", "Xeovrenth Adjure");
        this.addPentacle("craft_foliot", "Eziveus' Spectral Compulsion");
        this.addPentacle("craft_djinni", "Strigeor's Higher Binding");
        this.addPentacle("craft_afrit", "Sevira's Permanent Confinement");
        this.addPentacle("craft_marid", "Uphyxes Inverted Tower");
        this.addPentacle("resurrect_spirit", "Susje's Simple Circle");
        this.addPentacle("contact_wild_spirit", "Osorin's Unbound Calling");
        this.addPentacle("contact_eldritch_spirit", "Ronaza's Contact");
    }

    private void addPentacle(String id, String name) {
        this.add(Util.makeDescriptionId("multiblock", ResourceLocation.fromNamespaceAndPath(Occultism.MODID, id)), name);
    }

    private void addRitualDummies() {
        //Custom dummy
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_SUMMON.get(), "Custom Ritual Dummy");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_SUMMON.get(), "Used for modpacks as a fallback for custom rituals that do not have their own ritual item.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_POSSESS.get(), "Custom Ritual Dummy");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_POSSESS.get(), "Used for modpacks as a fallback for custom rituals that do not have their own ritual item.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_CRAFT.get(), "Custom Ritual Dummy");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_CRAFT.get(), "Used for modpacks as a fallback for custom rituals that do not have their own ritual item.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_MISC.get(), "Custom Ritual Dummy");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_MISC.get(), "Used for modpacks as a fallback for custom rituals that do not have their own ritual item.");

        //SUMMON
            //Crusher
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER, "Summon Foliot Crusher", "Foliot", "The Crusher is a spirit summoned to crush ores into dusts, effectively doubling the metal output.\n" + ChatFormatting.GRAY + ChatFormatting.ITALIC + "Note: Some recipes may require higher or lower tier crushers.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER, "Summon Djinni Crusher", "Djinni", "The Crusher is a spirit summoned to crush ores into dusts, effectively (more than) doubling the metal output.\n" + ChatFormatting.GRAY + ChatFormatting.ITALIC + "Note: Some recipes may require higher or lower tier crushers.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER, "Summon Afrit Crusher", "Afrit", "The Crusher is a spirit summoned to crush ores into dusts, effectively (more than) doubling the metal output.\n" + ChatFormatting.GRAY + ChatFormatting.ITALIC + "Note: Some recipes may require higher or lower tier crushers.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER, "Summon Marid Crusher", "Marid", "The Crusher is a spirit summoned to crush ores into dusts, effectively (more than) doubling the metal output.\n" + ChatFormatting.GRAY + ChatFormatting.ITALIC + "Note: Some recipes may require higher or lower tier crushers.");
            //Smelter
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER, "Summon Foliot Smelter", "Foliot", "The Smelter is a spirit summoned to make furnace, blast furnace, smoker and campfire recipes without using fuel and faster depending of the spirit.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER, "Summon Djinni Smelter", "Djinni", "The Smelter is a spirit summoned to make furnace, blast furnace, smoker and campfire recipes without using fuel and faster depending of the spirit.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER, "Summon Afrit Smelter", "Afrit", "The Smelter is a spirit summoned to make furnace, blast furnace, smoker and campfire recipes without using fuel and faster depending of the spirit.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER, "Summon Marid Smelter", "Marid", "The Smelter is a spirit summoned to make furnace, blast furnace, smoker and campfire recipes without using fuel and faster depending of the spirit.");
            //Partner
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_WIFE, "Summon Demonic Wife", "Djinni", "Summons a Demonic Wife to support you: She will fight for you, help with cooking, and extend potion durations.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_HUSBAND, "Summon Demonic Husband", "Djinni", "Summons a Demonic Husband to support you: He will fight for you, help with cooking, and extend potion durations.");
            //One tier worker
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_LUMBERJACK, "Summon Foliot Lumberjack", "Foliot", "The Lumberjack will harvest trees in it's working area and deposit the dropped items into the specified chest.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_OTHERSTONE_TRADER, "Summon Otherstone Trader", "Foliot", "The Otherstone Trader trades normal stone for otherstone.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SAPLING_TRADER, "Summon Otherworld Sapling Trader", "Foliot", "The Otherworld Sapling Trader trades natural otherworld saplings for stable ones, that can be harvested without the third eye.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_TRANSPORT_ITEMS, "Summon Foliot Transporter", "Foliot", "The Transporter will move all items it can access from one inventory to another, including machines.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CLEANER, "Summon Foliot Janitor", "Foliot", "The Janitor will pick up dropped items and deposit them into a target inventory.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_MANAGE_MACHINE, "Summon Djinni Machine Operator", "Djinni", "The Machine Operator automatically transfers items between dimensional storage systems and connected inventories and machines.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_DAY_TIME, "Summoning of Dawn", "Djinni", "Summons a Djinni that sets the time to high noon.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_NIGHT_TIME, "Summoning of Dusk", "Djinni", "Summons a Djinni that sets the time to midnight.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CLEAR_WEATHER, "Summoning of Clear Sky", "Djinni", "Summons a Djinni that clears the weather.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_RAIN_WEATHER, "Summoning of Rain", "Afrit", "Summons an Afrit that creates rain.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_THUNDER_WEATHER, "Summoning of Thunderstorm", "Afrit", "Summons an Afrit that creates a thunderstorm.");
            //Unbound
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_UNBOUND_AFRIT, "Summon Unbound Afrit", "Afrit", "Summons an Unbound Afrit that can be killed to obtain Afrit Essence.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_SUMMON_UNBOUND_MARID, "Summon Unbound Marid", "Marid", "Summons an Unbound Marid that can be killed to obtain Marid Essence.");
        //POSSESS
            //Familiar
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_BEAVER, "Summon Beaver Familiar", "Foliot", "The Beaver familiar provides increased woodcutting speed to their masters and harvests nearby trees when they grow from a sapling.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_BLACKSMITH, "Summon Blacksmith Familiar", "Foliot", "The Blacksmith familiars take stone their master mines and uses it to repair equipment.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_DEER, "Summon Deer Familiar", "Foliot", "The Deer familiars provide jump boost to their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_GREEDY, "Summon Greedy Familiar", "Foliot", "The Greedy familiars pick up items for their master. When stored in a familiar ring, they increase the pickup range (like an item magnet).");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_PARROT, "Summon Parrot Familiar", "Foliot", "The Parrot familiars behave exactly like tamed parrots.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_UNBOUND_PARROT, "Possess Unbound Parrot", "Foliot", "Possess a Parrot that can be tamed by anyone, not just the summoner.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_BAT, "Summon Bat Familiar", "Djinni", "The Bat familiars provide night vision to their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_BEHOLDER, "Summon Beholder Familiar", "Djinni", "The Beholder familiars highlight nearby entities with a glow effect and shoot laser rays at enemies.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_CHIMERA, "Summon Chimera Familiar", "Djinni", "The Chimera familiars can be fed to grow in size and gain attack speed and damage. Once big enough, players can ride them.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_CTHULHU, "Summon Cthulhu Familiar", "Djinni", "The Cthulhu familiars provide water breathing to their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_DEVIL, "Summon Devil Familiar", "Djinni", "The Devil familiars provide fire resistance to their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_DRAGON, "Summon Dragon Familiar", "Djinni", "The Dragon familiars provide increased experience gain to their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_FAIRY, "Summon Fairy Familiar", "Djinni", "The Fairy familiar keeps other familiars from dying, drains enemies of their life force and heals its master and their familiars.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_HEADLESS, "Summon Headless Ratman Familiar", "Djinni", "The Headless ratman familiars increase their master's attack damage against enemies of the kind it stole the head from.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_MUMMY, "Summon Mummy Familiar", "Djinni", "The Mummy familiar is a martial arts expert and fights to protect their master.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_OTHERWORLD_BIRD, "Summon Drikwing Familiar", "Djinni", "The Drikwings will provide their owner with limited flight abilities when nearby.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_UNBOUND_OTHERWORLD_BIRD, "Possess Unbound Drikwing", "Djinni", "Possess a Drikwing Familiar that can be tamed by anyone, not just the summoner.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FAMILIAR_GUARDIAN, "Summon Guardian Familiar", "Afrit", "The Guardian familiars prevent their master's violent demise.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM, "Summon Iesnium Golem", "Marid", "Summons the strong and invulnerable iesnium golem to defend a region.");
            //Possessed
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_ENDERMITE, "Summon Possessed Endermite", "Foliot", "The Possessed Endermite drops End Stone.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_PHANTOM, "Summon Possessed Phantom", "Foliot", "The Possessed Phantom will always drop at least one phantom membrane when killed and is easy to trap.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_SKELETON, "Summon Possessed Skeleton", "Foliot", "The Possessed Skeleton is immune to daylight and always drop at least one Skeleton Skull when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_WITCH, "Summon Possessed Witch", "Foliot", "The Possessed Witch will drop a special filled bottle.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_ENDERMAN, "Summon Possessed Enderman", "Djinni", "The Possessed Enderman will always drop at least one ender pearl when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_BEE, "Summon Possessed Bee", "Djinni", "The Possessed Bee will drop cursed honey.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_GHAST, "Summon Possessed Ghast", "Djinni", "The Possessed Ghast will always drop at least one ghast tear when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_WEAK_SHULKER, "Summon Possessed Weak Shulker", "Djinni", "The Possessed Weak Shulker will drop at least one chorus fruit when killed and can drop shulker shell.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_ZOMBIE_PIGLIN, "Summon Possessed Zombified Piglin", "Afrit", "The Possessed Zombified Piglin will drop demonic meat.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_WARDEN, "Summon Possessed Warden", "Afrit", "The Possessed Warden will always drop at least six echo shard and can drop anothers ancient stuff (smithing templates and discs) when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_ELDER_GUARDIAN, "Summon Possessed Elder Guardian", "Afrit", "The Possessed Elder Guardian will drop at least one nautilus shell when killed, also can drop heart of the sea and the common drops.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_HOGLIN, "Summon Possessed Hoglin", "Afrit", "The Possessed Hoglin has a chance to drop smithing template of netherite upgrade when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_SHULKER, "Summon Possessed Shulker", "Afrit", "The Possessed Shulker will always drop at least one shulker shell when killed.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_GOAT, "Summon Goat of Mercy", "Marid", "The Goat of Mercy will drop the Cruelty Essence.");
            //Random
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_COMMON, "Summon Common Random Animal", "Foliot", "Summons a common random passive animal. (Possibilities: chicken, cow, pig, sheep, squid, wolf)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_WATER, "Summon Water Random Animal", "Foliot", "Summons a Water random passive animal. (Possibilities: axolotl, frog, dolphin, cod, salmon, tropical fish, pufferfish, squid, glow squid, tadpole, turtle, snow golem)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SMALL, "Summon Small Random Animal", "Foliot", "Summons a small random passive animal. (Possibilities: allay, bat, bee, parrot, cat, ocelot, fox, rabbit)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SPECIAL, "Summon Special Random Animal", "Djinni", "Summons a special random passive animal. (Possibilities: armadillo, mooshroom, panda, polar bear, goat, iron golem, sniffer)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_RIDEABLE, "Summon Rideable Random Animal", "Djinni", "Summons a rideable random passive animal. (Possibilities: pig, camel, donkey, horse, skeleton horse, zombie horse, llama, trader llama, mule, strider)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_POSSESS_VILLAGER, "Summon Villager", "Djinni", "Summons a villager or wandering Trader.");
        //CRAFT
            //Tools
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_INFUSED_LENSES, "Craft Infused Lenses", "Foliot", "These lenses are used to craft spectacles that give thee ability to see beyond the physical world.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_INFUSED_PICKAXE, "Craft Infused Pickaxe", "Djinni", "Infuse a Pickaxe to mine otherworld ores.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_SATCHEL, "Craft Surprisingly Substantial Satchel", "Foliot", "This satchels allows to store more items than it's size would indicate, making it a practical traveller's companion.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1, "Craft Apprentice Ritual Satchel", "Foliot", "Binds a Foliot into a satchel to build pentacles step-by-step for the summoner.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2, "Craft Artisanal Ritual Satchel", "Afrit", "Binds an Afrit into a satchel to build pentacles all at once for the summoner.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_FRAGILE_SOUL_GEM, "Craft Fragile Soul Gem", "Foliot", "The Fragile Soul Gem allows the temporary storage of living beings. It can only be used once.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_SOUL_GEM, "Craft Soul Gem", "Djinni", "The Soul Gem allows the temporary storage of living beings.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_FAMILIAR_RING, "Craft Familiar Ring", "Djinni", "The Familiar Ring allows to store familiars. The ring will apply the familiar effect to the wearer.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_TRUE_SIGHT_STAFF, "Craft True Sight Staff", "Marid", "The true sight staff give abilities to find, see and interact with the otherworld.");
            //Miners
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_DIMENSIONAL_MINESHAFT, "Craft Dimensional Mineshaft", "Djinni", "Allows miner spirits to enter the mining dimension and bring back resources.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_MINER_FOLIOT_UNSPECIALIZED, "Infuse Foliot Miner", "Foliot", "Summon Foliot Miner into a magic lamp.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_MINER_DJINNI_ORES, "Infuse Djinni Ore Miner", "Djinni", "Summon Djinni Ore Miner into a magic lamp.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_MINER_AFRIT_DEEPS, "Infuse Afrit Deep Ore Miner", "Afrit", "Summon Afrit Deep Ore Miner into a magic lamp.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_MINER_MARID_MASTER, "Infuse Marid Master Miner", "Marid", "Summon Marid Master Miner into a magic lamp.");
            //Storage
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STORAGE_CONTROLLER_BASE, "Craft Storage Actuator Base", "Foliot", "The Storage Actuator Base imprisons a Foliot responsible for interacting with items in a dimensional storage matrix.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_DIMENSIONAL_MATRIX, "Craft Dimensional Matrix", "Djinni", "The Dimensional Matrix is the entry point to a small dimension used for storing items.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STABILIZER_TIER1, "Craft Storage Stabilizer Tier 1", "Foliot", "The Storage Stabilizer allows to store more items in the dimensional storage accessor.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STABILIZER_TIER2, "Craft Storage Stabilizer Tier 2", "Djinni", "The Storage Stabilizer allows to store more items in the dimensional storage accessor.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STABILIZER_TIER3, "Craft Storage Stabilizer Tier 3", "Afrit", "The Storage Stabilizer allows to store more items in the dimensional storage accessor.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STABILIZER_TIER4, "Craft Storage Stabilizer Tier 4", "Marid", "The Storage Stabilizer allows to store more items in the dimensional storage accessor.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STABLE_WORMHOLE, "Craft Stable Wormhole", "Foliot", "The Stable Wormhole allows access to a dimensional matrix from a remote destination.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_STORAGE_REMOTE, "Craft Storage Accessor", "Djinni", "The Storage Accessor can be linked to a Storage Actuator to remotely access items.");
            //Materials
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_RESEARCH_FRAGMENT_DUST, "Craft Research Fragment Dust", "Foliot", "A Foliot will infuse experience in the emerald dust.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_NATURE_PASTE, "Craft Nature Paste", "Foliot", "A Foliot will craft the nature paste mixing ingredients.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_GRAY_PASTE, "Craft Gray Paste", "Djinni", "A Djinni will craft the gray paste mixing ingredients.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_WITHERITE_DUST, "Craft Witherite Dust", "Afrit", "An Afrit will infuse netherite dust with wither essence.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_DRAGONYST_DUST, "Craft Dragonyst Dust", "Marid", "A Marid will infuse ender dragon essence in the amethyst dust.");
            //Extras
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL, "Craft Iesnium Sacrificial Bowl", "Afrit", "The Iesnium Sacrificial Bowl performs any ritual in only a quarter of the normal time. All other things will works like the Golden Sacrificial Bowl.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL, "Craft Iesnium Anvil", "Marid", "The iesnium anvil is an improvement on the common anvil, see all the advantages in the dictionary.");
            //Repair
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_REPAIR_CHALKS, "Repair Chalk", "Djinni", "Fully repair chalk by infusing it with a Djinni.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_REPAIR_TOOLS, "Repair Tool", "Afrit", "Fully repair a tool by infusing it with an Afrit.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_REPAIR_ARMORS, "Repair Armor", "Afrit", "Fully repair armor by infusing it with an Afrit.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_REPAIR_MINERS, "Repair Miner", "Afrit", "Extend a Miner's contract by striking a deal with an Afrit.");
        //MISC
            //Resurrect
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_RESURRECT_FAMILIAR, "Resurrect Familiar", "Familiar", "Resurrects a Familiar from a Soul Shard.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_RESURRECT_ALLAY, "Purify Vex to Allay", "Familiar", "Purifies a Vex into an Allay through resurrection.");
            //Wild
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_HUNT, "Invoke The Wild Hunt", "Wild", "The Wild Hunt consists of Wither Skeletons that as a big chance to drop Wither Skeleton Skulls, and their minions.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_CREEPER, "Invoke a Horde of Creeper", "Wild", "The Wild Horde Creeper consists of a few charged creepers that drop many disks.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_DROWNED, "Invoke a Horde of Drowned", "Wild", "The Wild Horde Drowned consists of a few drowneds that drop items related to ocean trails.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_HUSK, "Invoke a Horde of Husk", "Wild", "The Wild Horde Husk consists of a few husks that drop items related to desert trails.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_SILVERFISH, "Invoke a Horde of Silverfish", "Wild", "The Wild Horde Silverfish consists of a few silverfishs that drop items related to ruins trails.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_WEAK_BREEZE, "Invoke Wild Weak Breeze", "Wild", "The Wild Weak Breeze will drop a Trial Key and trial chamber related items.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_BREEZE, "Invoke Wild Breeze", "Wild", "The Wild Breeze will drop a Ominous Trial Key and trial chamber related items.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_STRONG_BREEZE, "Invoke Wild Strong Breeze", "Wild", "The Wild Strong Breeze will drop a Heavy Core and trial chamber related items.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_ILLAGER, "Invoke Wild Illagers", "Wild", "Summon a Wild Evoker and his henchmen.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_COMMON, "Invoke Common Random Animal Group", "Wild", "Summons a group of common random passive animal. (Possibilities: chicken, cow, pig, sheep, squid, wolf)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_WATER, "Invoke Water Random Animal Group", "Wild", "Summons a group of Water random passive animal. (Possibilities: axolotl, frog, dolphin, cod, salmon, tropical fish, pufferfish, squid, glow squid, tadpole, turtle, snow golem)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SMALL, "Invoke Small Random Animal Group", "Wild", "Summons a group of small random passive animal. (Possibilities: allay, bat, bee, parrot, cat, ocelot, fox, rabbit)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SPECIAL, "Invoke Special Random Animal Group", "Wild", "Summons a group of special random passive animal. (Possibilities: armadillo, mooshroom, panda, polar bear, goat, iron golem, sniffer)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_RIDEABLE, "Invoke Rideable Random Animal Group", "Wild", "Summons a group of rideable random passive animal. (Possibilities: pig, camel, donkey, horse, skeleton horse, zombie horse, llama, trader llama, mule, strider)");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_WILD_VILLAGER, "Invoke Villager Group", "Wild", "Summons a group of villager and wandering Trader.");
            //Forge
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST, "Forge Bee Nest", "Wild", "Wild Spirits will forge a bee nest, more beautiful than beehive.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_BELL, "Forge Bell", "Wild", "Wild Spirits will forge a bell.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST, "Forge Budding Amethyst", "Wild", "Wild Spirits will forge a Budding Amethyst.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_WILD_TRIM, "Forge Wild Armor Trim Smithing Template", "Wild", "Wild Spirits will forge a Wild Armor Trim Smithing Template.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE, "Forge Reinforced Deepslate", "Wild", "Wild Spirits will forge a Reinforced Deepslate.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE, "Forge Eldritch Chalice", "Eldritch", "Eldritch Spirits will forge an Eldritch Chalice, that performs any ritual instantly. Here is your trophy.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW, "Forge Rainbow Chalk", "Eldritch", "Eldritch Spirits will forge a rainbow chalk, substitute any colored chalk.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID, "Forge Void Chalk", "Eldritch", "Eldritch Spirits will forge a rainbow chalk, substitute any chalk.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM, "Forge Trinity Gem", "Eldritch", "Eldritch Spirits will forge a trinity gem, upgrading a soul gem.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE, "Forge Stabilized Dimensional Storage Actuator", "Eldritch", "Eldritch Spirits will forge a Stabilized Dimensional Storage Actuator, works as an actuator with maximum stabilizers in only one block.");
        this.autoDummyFactory(OccultismItems.RITUAL_DUMMY_FORGE_MINER_ANCIENT_ELDRITCH, "Infuse Eldritch Ancient Miner", "Eldritch", "Summon Eldritch Ancient Miner into a magic lamp.");
    }

    public void autoDummyFactory(DeferredItem<Item> dummy, String name, String tier, String description) {
        this.add(dummy.get(), "Ritual: " + name);
        this.addTooltip(dummy.get(), description);
        this.addAutoTooltip(dummy.get(), "Tier: " + tier);
        this.addRitualMessage(dummy, "conditions", "Not all requirements for this ritual are met.");
        this.addRitualMessage(dummy, "started", "Starting the ritual: " + name +".");
        this.addRitualMessage(dummy, "finished", "Ritual completed successfully: " + name +".");
        this.addRitualMessage(dummy, "interrupted", "Interruption in the ritual: " + name +".");
    }

    public void addTooltip(ItemLike key, String value) {
        this.add(key.asItem().getDescriptionId() + ".tooltip", value);
    }

    public void addAutoTooltip(ItemLike key, String value) {
        this.add(key.asItem().getDescriptionId() + ".auto_tooltip", value);
    }

    private void addDialogs() {
        this.add("dialog.occultism.dragon.pet", "purrr");
        this.add("dialog.occultism.mummy.kapow", "KAPOW!");
        this.add("dialog.occultism.beaver.snack_on_cooldown", "Hey now, don't be greedy!");
        this.add("dialog.occultism.beaver.no_upgrade", "A Blacksmith Familiar needs to upgrade the Beaver before he dispenses snacks!");
        this.add("dialog.occultism.fairy.breath_on_cooldown", "Hey listen, wait!");
        this.add("dialog.occultism.fairy.no_upgrade", "A Blacksmith Familiar needs to upgrade the Fairy before breathing like a dragon!");
        this.add("dialog.occultism.devil.sin_on_cooldown", "Another will be available after: %s ticks!");
        this.add("dialog.occultism.devil.no_upgrade", "A Blacksmith Familiar needs to upgrade the Devil before sinning!");
    }

    private void addModonomiconIntegration() {
        this.add(I18n.RITUAL_RECIPE_ITEM_USE, "Item to use:");
        this.add(I18n.RITUAL_RECIPE_SUMMON, "Summon: %s");
        this.add(I18n.RITUAL_RECIPE_JOB, "Job: %s");
        this.add(I18n.RITUAL_RECIPE_SACRIFICE, "Sacrifice: %s");
        this.add(I18n.RITUAL_RECIPE_GO_TO_PENTACLE, "Open Pentacle Page: %s");
    }

    private void advancementTitle(String name, String s) {
        this.add(((TranslatableContents) OccultismAdvancementSubProvider.title(name).getContents()).getKey(), s);
    }

    private void advancementDescr(String name, String s) {
        this.add(((TranslatableContents) OccultismAdvancementSubProvider.descr(name).getContents()).getKey(), s);
    }

    private void addTags() {
        // Block tags
        this.addBlockTag(OccultismTags.Blocks.OTHERWORLD_SAPLINGS, "Otherworld Saplings");
        this.addBlockTag(OccultismTags.Blocks.OTHERWORLD_SAPLINGS_NATURAL, "Otherworld Saplings_NATURAL");
        this.addBlockTag(OccultismTags.Blocks.CANDLES, "Candles");
        this.addBlockTag(OccultismTags.Blocks.CAVE_WALL_BLOCKS, "Cave Wall Blocks");
        this.addBlockTag(OccultismTags.Blocks.NETHERRACK, "Netherrack");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_STABILIZER, "Storage Stabilizer Blocks");
        this.addBlockTag(OccultismTags.Blocks.TREE_SOIL, "Tree Soil Blocks");
        this.addBlockTag(OccultismTags.Blocks.WORLDGEN_BLACKLIST, "Worldgen Blacklisted Blocks");
        this.addBlockTag(OccultismTags.Blocks.IESNIUM_ORE, "Iesnium Ore");
        this.addBlockTag(OccultismTags.Blocks.SILVER_ORE, "Silver Ore");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_IESNIUM, "Iesnium Storage Blocks");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_SILVER, "Silver Storage Blocks");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_RAW_IESNIUM, "Raw Iesnium Storage Blocks");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, "Raw Silver Storage Blocks");
        this.addBlockTag(OccultismTags.Blocks.OTHERWORLD_COLLECTS, "Otherworld can collect");

        // Item tags
        this.addItemTag(OccultismTags.Items.OTHERWORLD_SAPLINGS, "Otherworld Saplings");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_SAPLINGS_NATURAL, "Otherworld Saplings Natural");
        this.addItemTag(OccultismTags.Items.BOOK_OF_CALLING_DJINNI, "Book of Calling Djinni");
        this.addItemTag(OccultismTags.Items.BOOK_OF_CALLING_FOLIOT, "Book of Calling Foliot");
        this.addItemTag(OccultismTags.Items.BOOKS_OF_BINDING, "Books of Binding");
        this.addItemTag(OccultismTags.Items.Miners.BASIC_RESOURCES, "Basic Resource Miners");
        this.addItemTag(OccultismTags.Items.Miners.DEEPS, "Deepslate Miners");
        this.addItemTag(OccultismTags.Items.Miners.MASTER, "Rare Resource Miners");
        this.addItemTag(OccultismTags.Items.Miners.ELDRITCH, "Eldritch Miners");
        this.addItemTag(OccultismTags.Items.Miners.ORES, "General Miners");
        this.addItemTag(OccultismTags.Items.ELYTRA, "Elytras");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_GOGGLES, "Otherworld Goggles");
        this.addItemTag(OccultismTags.Items.DATURA_SEEDS, "Demon's Dream Seeds");
        this.addItemTag(OccultismTags.Items.DATURA_CROP, "Demon's Dream");
        this.addItemTag(OccultismTags.Items.COPPER_DUST, "Copper Dust");
        this.addItemTag(OccultismTags.Items.GOLD_DUST, "Gold Dust");
        this.addItemTag(OccultismTags.Items.IESNIUM_DUST, "Iesnium Dust");
        this.addItemTag(OccultismTags.Items.IRON_DUST, "Iron Dust");
        this.addItemTag(OccultismTags.Items.SILVER_DUST, "Silver Dust");
        this.addItemTag(OccultismTags.Items.END_STONE_DUST, "Crushed End Stone");
        this.addItemTag(OccultismTags.Items.OBSIDIAN_DUST, "Crushed Obsidian");
        this.addItemTag(OccultismTags.Items.IESNIUM_INGOT, "Iesnium Ingot");
        this.addItemTag(OccultismTags.Items.SILVER_INGOT, "Silver Ingot");
        this.addItemTag(OccultismTags.Items.IESNIUM_NUGGET, "Iesnium Nugget");
        this.addItemTag(OccultismTags.Items.SILVER_NUGGET, "Silver Nugget");
        this.addItemTag(OccultismTags.Items.IESNIUM_ORE, "Iesnium Ore");
        this.addItemTag(OccultismTags.Items.SILVER_ORE, "Silver Ore");
        this.addItemTag(OccultismTags.Items.RAW_IESNIUM, "Raw Iesnium");
        this.addItemTag(OccultismTags.Items.RAW_SILVER, "Raw Silver");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_IESNIUM, "Iesnium Storage Blocks");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_SILVER, "Silver Storage Blocks");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_RAW_IESNIUM, "Raw Iesnium Storage Blocks");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_RAW_SILVER, "Raw Silver Storage Blocks");
        this.addItemTag(OccultismTags.Items.MUSHROOM_BLOCKS, "Mushroom Blocks");
        this.addItemTag(OccultismTags.Items.TALLOW, "Tallow");
        this.addItemTag(OccultismTags.Items.METAL_AXES, "Metal Axes");
        this.addItemTag(OccultismTags.Items.MAGMA, "Magma");
        this.addItemTag(OccultismTags.Items.BOOKS, "Books");
        this.addItemTag(OccultismTags.Items.FRUITS, "Fruits");
        this.addItemTag(OccultismTags.Items.AMETHYST_DUST,"Amethyst Dust");
        this.addItemTag(OccultismTags.Items.BLACKSTONE_DUST,"Blackstone Dust");
        this.addItemTag(OccultismTags.Items.BLUE_ICE_DUST,"Blue Ice Dust");
        this.addItemTag(OccultismTags.Items.CALCITE_DUST,"Calcite Dust");
        this.addItemTag(OccultismTags.Items.ICE_DUST,"Ice Dust");
        this.addItemTag(OccultismTags.Items.PACKED_ICE_DUST,"Packed Ice Dust");
        this.addItemTag(OccultismTags.Items.DRAGONYST_DUST,"Dragonyst Dust");
        this.addItemTag(OccultismTags.Items.ECHO_DUST,"Echo Dust");
        this.addItemTag(OccultismTags.Items.EMERALD_DUST,"Emerald Dust");
        this.addItemTag(OccultismTags.Items.LAPIS_DUST,"Lapis Dust");
        this.addItemTag(OccultismTags.Items.NETHERITE_DUST,"Netherite Dust");
        this.addItemTag(OccultismTags.Items.NETHERITE_SCRAP_DUST,"Netherite Scrap Dust");
        this.addItemTag(OccultismTags.Items.RESEARCH_DUST,"Research Dust");
        this.addItemTag(OccultismTags.Items.WITHERITE_DUST,"Witherite Dust");
        this.addItemTag(OccultismTags.Items.OTHERSTONE_DUST,"Otherstone Dust");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_WOOD_DUST,"Otherworld Wood Dust");
        this.addItemTag(OccultismTags.Items.OCCULTISM_CANDLES,"Occultism Candles");
        this.addItemTag(OccultismTags.Items.Miners.MINERS,"Dimensional Miners");
        this.addItemTag(OccultismTags.Items.SCUTESHELL,"Scute or Shell");
        this.addItemTag(OccultismTags.Items.BLAZE_DUST, "Blaze Dust");
        this.addItemTag(OccultismTags.Items.MANUALS, "Manuals");
        this.addItemTag(OccultismTags.Items.TOOLS_KNIFE, "Knives");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("c", "tools/knife"), "Knives");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "belt"), "Belts");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "hands"), "Hands");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "head"), "Head");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "ring"), "Ring");
        this.addItemTag(OccultismTags.Items.DEMONIC_PARTNER_FOOD, "Demonic Partner Food");
        this.addItemTag(OccultismTags.Items.OTHERCOBBLESTONE, "Other Cobblestone");
        this.addItemTag(OccultismTags.Items.OTHERSTONE, "Otherstone");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_LOGS, "Otherworld Logs");
        this.addItemTag(OccultismTags.Items.PENTACLE_MATERIALS, "Pentacle Materials");
        this.addItemTag(OccultismTags.Items.TOOLS_CHALK, "Chalks");
        this.addItemTag(OccultismTags.Items.CLAY, "Clay");
    }

    private void addItemTag(ResourceLocation resourceLocation, String string) {
        this.add("tag.item." + resourceLocation.getNamespace() + "." + resourceLocation.getPath().replace("/", "."), string);
    }

    private void addBlockTag(TagKey<Block> block, String string) {
        this.addBlockTag(block.location(), string);
    }

    private void addItemTag(TagKey<Item> item, String string) {
        this.addItemTag(item.location(), string);
    }

    private void addBlockTag(ResourceLocation resourceLocation, String string) {
        this.add("tag.block." + resourceLocation.getNamespace() + "." + resourceLocation.getPath().replace("/", "."), string);
    }

    private void addEmiTranslations() {
        this.add("emi.category.occultism.spirit_fire", "Spirit Fire");
        this.add("emi.category.occultism.crushing", "Crushing");
        this.add("emi.category.occultism.miner", "Dimensional Mineshaft");
        this.add("emi.category.occultism.ritual", "Rituals");
        this.add("emi.occultism.item_to_use", "Item to use: %s");
        this.add("emi.occultism.ritual_duration", "%s seconds");
    }

    private void addConditionMessages() {
        this.add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_TYPE_NOT_FULFILLED, "Perform the ritual in a %s dimension! It was performed in %s.");
        this.add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_TYPE_DESCRIPTION, "Needs to be performed in a %s dimension.");

        this.add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_NOT_FULFILLED, "Perform the ritual in the %s dimension! It was performed in %s.");
        this.add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_DESCRIPTION, "Needs to be performed in the %s dimension.");

        this.add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_NOT_FULFILLED, "Perform the ritual in the %s biome! It was performed in %s.");
        this.add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_DESCRIPTION, "Needs to be performed in the %s biome.");

        this.add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_WITH_TAG_NOT_FULFILLED, "Perform the ritual in a biome with the tag %s! It was performed in the biome %s which does not have the tag.");
        this.add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_WITH_TAG_DESCRIPTION, "Needs to be performed in a biome with the tag %s.");

        this.add(TranslationKeys.Condition.Ritual.AND_NOT_FULFILLED, "One or more of the required conditions were not met (all must be met): %s");
        this.add(TranslationKeys.Condition.Ritual.AND_DESCRIPTION, "All of the following conditions need to be met: %s");

        this.add(TranslationKeys.Condition.Ritual.OR_NOT_FULFILLED, "None of the required conditions were met (at least one must be met): %s");
        this.add(TranslationKeys.Condition.Ritual.OR_DESCRIPTION, "At least one of the following conditions needs to be met: %s");

        this.add(TranslationKeys.Condition.Ritual.TRUE_NOT_FULFILLED, "Always Fulfilled Condition somehow not fulfilled. This should never happen.");
        this.add(TranslationKeys.Condition.Ritual.TRUE_DESCRIPTION, "This condition is always fulfilled.");

        this.add(TranslationKeys.Condition.Ritual.FALSE_NOT_FULFILLED, "This Condition is never fulfilled. Use a different condition in the recipe to make the ritual work.");
        this.add(TranslationKeys.Condition.Ritual.FALSE_DESCRIPTION, "This condition is never fulfilled.");

        this.add(TranslationKeys.Condition.Ritual.NOT_NOT_FULFILLED, "The condition was met, but should not be met: %s");
        this.add(TranslationKeys.Condition.Ritual.NOT_DESCRIPTION, "The following condition must not be met: %s");

        this.add(TranslationKeys.Condition.Ritual.ITEM_EXISTS_NOT_FULFILLED, "The item %s does not exist.");
        this.add(TranslationKeys.Condition.Ritual.ITEM_EXISTS_DESCRIPTION, "The item %s must exist.");


        this.add(TranslationKeys.Condition.Ritual.MOD_LOADED_NOT_FULFILLED, "The mod %s is not loaded.");
        this.add(TranslationKeys.Condition.Ritual.MOD_LOADED_DESCRIPTION, "The mod %s must be loaded.");

        this.add(TranslationKeys.Condition.Ritual.TAG_EMPTY_NOT_FULFILLED, "The tag %s is not empty.");
        this.add(TranslationKeys.Condition.Ritual.TAG_EMPTY_DESCRIPTION, "The tag %s must be empty.");

    }

    private void addConfigurationTranslations() {

        this.addConfig("visual", "Visual Settings");
        this.addConfig("showItemTagsInTooltip", "Show Item Tags in Tooltips");
        this.addConfig("disableDemonsDreamShaders", "Disable Demon's Dream Shaders");
        this.addConfig("disableHolidayTheming", "Disable Otherworld Goggles Shaders");
        this.addConfig("useAlternativeDivinationRodRenderer", "Use Alternative Divination Rod Renderer");
        this.addConfig("whiteChalkGlyphColor", "White Chalk Glyph Color");
        this.addConfig("yellowChalkGlyphColor", "Yellow Chalk Glyph Color");
        this.addConfig("purpleChalkGlyphColor", "Purple Chalk Glyph Color");
        this.addConfig("redChalkGlyphColor", "Red Chalk Glyph Color");
        this.addConfig("lightGrayChalkGlyphColor", "Light Gray Chalk Glyph Color");
        this.addConfig("grayChalkGlyphColor", "Gray Chalk Glyph Color");
        this.addConfig("blackChalkGlyphColor", "Black Chalk Glyph Color");
        this.addConfig("brownChalkGlyphColor", "Brown Chalk Glyph Color");
        this.addConfig("orangeChalkGlyphColor", "Orange Chalk Glyph Color");
        this.addConfig("limeChalkGlyphColor", "Lime Chalk Glyph Color");
        this.addConfig("greenChalkGlyphColor", "Green Chalk Glyph Color");
        this.addConfig("cyanChalkGlyphColor", "Cyan Chalk Glyph Color");
        this.addConfig("lightBlueChalkGlyphColor", "Light Blue Chalk Glyph Color");
        this.addConfig("blueChalkGlyphColor", "Blue Chalk Glyph Color");
        this.addConfig("magentaChalkGlyphColor", "Magenta Chalk Glyph Color");
        this.addConfig("pinkChalkGlyphColor", "Pink Chalk Glyph Color");

        this.addConfig("misc", "Misc Settings");
        this.addConfig("syncJeiSearch", "Sync JEI Search");
        this.addConfig("divinationRodHighlightAllResults", "Divination Rod Highlight All Results");
        this.addConfig("divinationRodScanRange", "Divination Rod Scan Range");
        this.addConfig("disableSpiritFireSuccessSound", "Disable Spirit Fire Success Sound");

        this.addConfig("storage", "Storage Settings");
        this.addConfig("stabilizerTier1AdditionalMaxItemTypes", "Stabilizer Tier 1 Additional Max Item Types");
        this.addConfig("stabilizerTier1AdditionalMaxTotalItemCount", "Stabilizer Tier 1 Additional Max Total Item Count");
        this.addConfig("stabilizerTier2AdditionalMaxItemTypes", "Stabilizer Tier 2 Additional Max Item Types");
        this.addConfig("stabilizerTier2AdditionalMaxTotalItemCount", "Stabilizer Tier 2 Additional Max Total Item Count");
        this.addConfig("stabilizerTier3AdditionalMaxItemTypes", "Stabilizer Tier 3 Additional Max Item Types");
        this.addConfig("stabilizerTier3AdditionalMaxTotalItemCount", "Stabilizer Tier 3 Additional Max Total Item Count");
        this.addConfig("stabilizerTier4AdditionalMaxItemTypes", "Stabilizer Tier 4 Additional Max Item Types");
        this.addConfig("stabilizerTier4AdditionalMaxTotalItemCount", "Stabilizer Tier 4 Additional Max Total Item Count");
        this.addConfig("controllerMaxItemTypes", "Controller Max Item Types");
        this.addConfig("controllerMaxTotalItemCount", "Controller Max Total Item Count");
        this.addConfig("stabilizedControllerStabilizers", "Stabilized Controller Built-in Stabilizers");
        this.addConfig("unlinkWormholeOnBreak", "Unlink Wormhole on Break");

        this.addConfig("spirit_job", "Spirit Job Settings");
        this.addConfig("drikwingFamiliarSlowFallingSeconds", "Duration of slow falling effect given by Drikwing Familiar in seconds.");
        this.addConfig("tier1CrusherTimeMultiplier", "Time multiplier for Tier 1 Crusher operations.");
        this.addConfig("tier2CrusherTimeMultiplier", "Time multiplier for Tier 2 Crusher operations.");
        this.addConfig("tier3CrusherTimeMultiplier", "Time multiplier for Tier 3 Crusher operations.");
        this.addConfig("tier4CrusherTimeMultiplier", "Time multiplier for Tier 4 Crusher operations.");
        this.addConfig("tier1CrusherOutputMultiplier", "Output multiplier for Tier 1 Crusher operations.");
        this.addConfig("tier2CrusherOutputMultiplier", "Output multiplier for Tier 2 Crusher operations.");
        this.addConfig("tier3CrusherOutputMultiplier", "Output multiplier for Tier 3 Crusher operations.");
        this.addConfig("tier4CrusherOutputMultiplier", "Output multiplier for Tier 4 Crusher operations.");
        this.addConfig("crusherResultPickupDelay", "Delay before items from crusher operations can be picked up.");
        this.addConfig("tier1SmelterTimeMultiplier", "Time multiplier for Tier 1 Smelter operations.");
        this.addConfig("tier2SmelterTimeMultiplier", "Time multiplier for Tier 2 Smelter operations.");
        this.addConfig("tier3SmelterTimeMultiplier", "Time multiplier for Tier 3 Smelter operations.");
        this.addConfig("tier4SmelterTimeMultiplier", "Time multiplier for Tier 4 Smelter operations.");
        this.addConfig("smelterResultPickupDelay", "Delay before items from smelter operations can be picked up.");
        this.addConfig("blacksmithFamiliarRepairChance", "Chance for Blacksmith Familiar to repair an item each tick.");
        this.addConfig("blacksmithFamiliarUpgradeCost", "Cost in experience levels for upgrading items with Blacksmith Familiar.");
        this.addConfig("blacksmithFamiliarUpgradeCooldown", "Cooldown in ticks before Blacksmith Familiar can upgrade items again.");
        this.addConfig("greedySearchRange", "Upgraded Greedy familiar horizontal search range");
        this.addConfig("greedyVerticalSearchRange", "Upgraded Greedy familiar vertical search range");

        this.addConfig("rituals", "Rituals Settings");
        this.addConfig("enableClearWeatherRitual", "Enable the ritual to clear weather conditions.");
        this.addConfig("enableRainWeatherRitual", "Enable the ritual to cause rain weather conditions.");
        this.addConfig("enableThunderWeatherRitual", "Enable the ritual to cause thunderstorm weather conditions.");
        this.addConfig("enableDayTimeRitual", "Enable the ritual to change the time to day.");
        this.addConfig("enableNightTimeRitual", "Enable the ritual to change the time to night.");
        this.addConfig("enableRemainingIngredientCountMatching", "Enable matching of remaining ingredients in ritual recipes.");
        this.addConfig("ritualDurationMultiplier", "Multiplier to adjust the duration of all rituals.");
        this.addConfig("possibleSpiritNames", "Possible Spirit Names");

        this.addConfig("dimensional_mineshaft", "Dimensional Mineshaft Settings");
        this.addConfig("miner_foliot_unspecialized", "Foliot Miner Unspectialized");
        this.addConfig("miner_djinni_ores", "Djinni Ore Miner");
        this.addConfig("miner_afrit_deeps", "Afrit Deep Ore Miner");
        this.addConfig("miner_marid_master", "Marid Master Miner");
        this.addConfig("miner_ancient_eldritch", "Eldritch Ancient Miner");

        this.addConfig("maxMiningTime", "Max Mining Time");
        this.addConfig("rollsPerOperation", "Rolls Per Operation");
        this.addConfig("durability", "Durability");

        this.addConfig("items", "Items");
        this.addConfig("anyOreDivinationRod", "Divination c:ores");
        this.addConfig("minerOutputBeforeBreak", "Save miners before breaking");
        this.addConfig("minerEfficiency", "Efficient miners");
        this.addConfig("minerFortune", "Fortune miners");
        this.addConfig("unbreakableChalks", "Unbreakable Chalks");
    }

    private void addConfig(String key, String name) {
        this.add(Occultism.MODID + ".configuration." + key, name);
    }

    @Override
    protected void addTranslations() {
        this.addAdvancements();
        this.addItems();
        this.addItemMessages();
        this.addItemTooltips();
        this.addBlocks();
        this.addBook();
        this.addEntities();
        this.addMiscTranslations();
        this.addRitualMessages();
        this.addGuiTranslations();
        this.addKeybinds();
        this.addJeiTranslations();
        this.addFamiliarSettingsMessages();
        this.addRitualDummies();
        this.addDialogs();
        this.addPentacles();
        this.addModonomiconIntegration();
        this.addEmiTranslations();
        this.addConfigurationTranslations();
        this.addTags();
        this.addConditionMessages();
        this.addWaila();
    }

    private void addWaila() {
        this.add("occultism.waila.current_ritual","Current Ritual: %s");
        this.add("occultism.waila.no_current_ritual","No Current Ritual");
        this.add("occultism.waila.no_item_use","Required item not used");
        this.add("occultism.waila.no_sacrifice","Required sacrifice not performed");
        this.add("occultism.waila.foliot","Foliot");
        this.add("occultism.waila.foliot_age","Foliot: %s seconds left");
        this.add("occultism.waila.djinni","Djinni");
        this.add("occultism.waila.djinni_age","DJinni: %s seconds left");
        this.add("occultism.waila.afrit","Afrit");
        this.add("occultism.waila.afrit_age","Afrit: %s seconds left");
        this.add("occultism.waila.marid","Marid");
        this.add("occultism.waila.marid_age","Marid: %s seconds left");
        this.add("config.jade.plugin_occultism.foliot", "Spirits Info");
        this.add("config.jade.plugin_occultism.sacrificial", "Sacrificial Bowl Info");

    }
}
