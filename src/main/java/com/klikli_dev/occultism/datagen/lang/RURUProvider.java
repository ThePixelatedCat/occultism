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

public class RURUProvider extends AbstractModonomiconLanguageProvider {

    public static final String COLOR_PURPLE = "ad03fc";
    public static final String DEMONS_DREAM = "Видение демона";


    public RURUProvider(PackOutput gen) {
        super(gen, Occultism.MODID, "ru_ru");
    }

    public RURUProvider lang(String lang) {
        return this;
    }

    public void addItemMessages() {

        //"item\.occultism\.(.*?)\.(.*)": "(.*)",
        // this.add\(OccultismItems.\U\1\E.get\(\).getDescriptionId\(\)  + " \2", "\3"\);

        //book of callings use generic message base key, hence the manual string
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_target_uuid_no_match", "Этот дух на данный момент не связан с книгой. Нажмите Shift + ПКМ по духу, чтобы связать.");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_target_linked", "Теперь этот дух связан с книгой.");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_target_cannot_link", "Этот дух не может быть связан с этой книгой. Книга вызова должна соответствовать задаче духа!");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_target_entity_no_inventory", "У этой сущности нет инвентаря: она не может быть установлена в качестве место ввода.");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_spirit_not_found", "Дух, связанный с этой книгой не обитает в этой параллельной реальности.");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_deposit", "%s будет вводить в %s со стороны: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_deposit_entity", "%s будет передавать предметы в: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_extract", "%s будет извлекать из %s со стороны: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_base", "База для %s установлена на %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_storage_controller", "%s теперь будет принимать заказы на изготовление из %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_work_area_size", "%s теперь будет отслеживать рабочую зону %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_managed_machine", "Настройки для машины %s обновлены.");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_set_managed_machine_extract_location", "%s теперь будет извлекать из %s со стороны: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling" + ".message_no_managed_machine", "Установите машину, прежде чем установить место извлечения %s");

        this.lang("ru_ru").add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".message.set_storage_controller", "Стабильная червоточина связана с регулятором хранилища.");
        this.lang("ru_ru").add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".message.not_loaded", "Чанк для актуатора хранилища не загружен!");
        this.lang("ru_ru").add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".message.linked", "Удалённое хранилище связано с актуатором.");
        this.lang("ru_ru").add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.no_linked_block", "Жезл прорицания не настроен на какой-либо материал.");
        this.lang("ru_ru").add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.linked_block", "Жезл прорицания настроен на %s");
        this.lang("ru_ru").add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".message.no_link_found", "Нет резонанса с этим блоком.");
        this.lang("ru_ru").add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".message.entity_type_denied", "Камень душ не может удерживать этот тип существа.");
    }

    public void addItemTooltips() {
        //"item\.occultism\.(.*?)\.(.*)": "(.*)",
        // this.add\(OccultismItems.\U\1\E.get\(\).getDescriptionId\(\)  + " \2", "\3"\);
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_EMPTY.get().getDescriptionId() + ".tooltip", "Эта книга пока не определена к какому-либо духу.");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_FOLIOT.get().getDescriptionId() + ".tooltip", "Эта книга пока не связана с Фолиотом.");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_BOUND_FOLIOT.get().getDescriptionId() + ".tooltip", "Может быть использована для вызова Фолиота %s");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_DJINNI.get().getDescriptionId() + ".tooltip", "Эта книга пока не связана с Джинном.");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_BOUND_DJINNI.get().getDescriptionId() + ".tooltip", "Может быть использована для вызова Джинна %s");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_AFRIT.get().getDescriptionId() + ".tooltip", "Эта книга пока не связана с Афритом.");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_BOUND_AFRIT.get().getDescriptionId() + ".tooltip", "Может быть использована для вызова Африта %s");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_MARID.get().getDescriptionId() + ".tooltip", "Эта книга пока не связана с Маридом.");
        this.lang("ru_ru").add(OccultismItems.BOOK_OF_BINDING_BOUND_MARID.get().getDescriptionId() + ".tooltip", "Может быть использована для вызова Марида %s");

        this.lang("ru_ru").add("item.occultism.book_of_calling_foliot" + ".tooltip", "Фолиот %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling_foliot" + ".tooltip_dead", "%s покинул эту параллельную реальность.");
        this.lang("ru_ru").add("item.occultism.book_of_calling_foliot" + ".tooltip.extract", "Извлекает из: %s.");
        this.lang("ru_ru").add("item.occultism.book_of_calling_foliot" + ".tooltip.deposit", "Вводит в: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling_foliot" + ".tooltip.deposit_entity", "Передаёт предметы в: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling_djinni" + ".tooltip", "Джинн %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling_djinni" + ".tooltip_dead", "%s покинул эту параллельную реальность.");
        this.lang("ru_ru").add("item.occultism.book_of_calling_djinni" + ".tooltip.extract", "Извлекает из: %s");
        this.lang("ru_ru").add("item.occultism.book_of_calling_djinni" + ".tooltip.deposit", "Вводит в: % s");
        this.lang("ru_ru").add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip", "Занято фамильяром: %s\n%s");
        this.lang("ru_ru").add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip.familiar_type", "[Тип: %s]");
        this.lang("ru_ru").add(OccultismItems.FAMILIAR_RING.get().getDescriptionId() + ".tooltip.empty", "Не содержит какого-либо фамильяра.");

        this.lang("ru_ru").add("item.minecraft.diamond_sword.occultism_spirit_tooltip", "%s заточён в этом мече. Пусть враги трепещут перед его тщеславием.");

        this.lang("ru_ru").add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".tooltip.unlinked", "Не связана с регулятором хранилища.");
        this.lang("ru_ru").add(OccultismItems.STABLE_WORMHOLE.get().getDescriptionId() + ".tooltip.linked", "Связана с регулятором хранилища в %s.");
        this.lang("ru_ru").add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".tooltip", "Удалённо получает доступ к сетевому хранилищу.");
		this.lang("ru_ru").add("block.occultism.otherglass.auto_tooltip", "Наденьте Потусторонние очки, чтобы видеть стекло.");

        this.lang("ru_ru").add(OccultismItems.STORAGE_REMOTE.get().getDescriptionId() + ".tooltip.linked", "Связано с %s.");
        this.lang("ru_ru").add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".tooltip.no_linked_block", "Не настроен на какой-либо материал.");
        this.lang("ru_ru").add(OccultismItems.DIVINATION_ROD.get().getDescriptionId() + ".tooltip.linked_block", "Настроен на %s");
        this.lang("ru_ru").add(OccultismItems.DIMENSIONAL_MATRIX.get().getDescriptionId() + ".tooltip", "%s связан с пространственной матрицей.");
        this.lang("ru_ru").add(OccultismItems.INFUSED_PICKAXE.get().getDescriptionId() + ".tooltip", "%s заточён в этой кирке.");
        this.lang("ru_ru").add(OccultismItems.MINER_FOLIOT_UNSPECIALIZED.get().getDescriptionId() + ".tooltip", "%s добывает разные блоки в шахтёрском измерении.");
        this.lang("ru_ru").add(OccultismItems.MINER_DJINNI_ORES.get().getDescriptionId() + ".tooltip", "%s добывает разные руды в шахтёрском измерении.");
        this.lang("ru_ru").add(OccultismItems.MINER_DEBUG_UNSPECIALIZED.get().getDescriptionId() + ".tooltip", "Отладочный рудокоп будет добывать разные блоки в шахтёрском измерении");
        this.lang("ru_ru").add(OccultismItems.MINER_AFRIT_DEEPS.get().getDescriptionId() + ".tooltip", "%s добывает разные и глубинносланцевые руды в шахтёрском измерении.");
        this.lang("ru_ru").add(OccultismItems.MINER_MARID_MASTER.get().getDescriptionId() + ".tooltip", "%s добывает: разные, глубинносланцевые и редкие руды в шахтёрском измерении.");
		this.lang("ru_ru").add(OccultismItems.MINER_ANCIENT_ELDRITCH.get().getDescriptionId() + ".tooltip", "Нечто будет добывать: разные рудные блоки, редкие руды и самоцветные блоки в шахтёрском измерении.");
        this.lang("ru_ru").add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_filled", "Содержит пойманного %s.");
        this.lang("ru_ru").add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + ".tooltip_empty", "Используйте по существу для его поимки.");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".tooltip_filled", "Содержит пойманного %s.");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".tooltip_empty", "Используйте по существу для его поимки.");
        this.lang("ru_ru").add(OccultismItems.SATCHEL.get().getDescriptionId() + ".tooltip", "%s заточён в этой сумке.");
		this.lang("ru_ru").add(OccultismItems.RITUAL_SATCHEL_T1.get().getDescriptionId() + ".tooltip", "%s заточён в этой сумке.");
        this.lang("ru_ru").add(OccultismItems.RITUAL_SATCHEL_T2.get().getDescriptionId() + ".tooltip", "%s заточён в этой сумке.");

        this.lang("ru_ru").add(OccultismItems.SOUL_SHARD_ITEM.get().getDescriptionId() + ".tooltip_filled", "Содержит душу %s.\Может быть использован для воскресения.");
        this.lang("ru_ru").add(OccultismItems.SOUL_SHARD_ITEM.get().getDescriptionId() + ".tooltip_empty", "Выпадает с Фамильяра после его преждевременной смерти. Может быть использован для воскресения.");
    }

    private void addItems() {
        //Магия Notepad++:
        //"item\.occultism\.(.*)": "(.*)"
        //this.addItem\(OccultismItems.\U\1\E, "\2"\);

        this.lang("ru_ru").add("itemGroup.occultism", "Occultism");

        this.addItem(OccultismItems.PENTACLE_SUMMON, "Пентакль для вызова");
		this.addItem(OccultismItems.PENTACLE_POSSESS, "Пентакль для одержимости");
        this.addItem(OccultismItems.PENTACLE_CRAFT, "Создание пентакля");
        this.addItem(OccultismItems.PENTACLE_MISC, "Пентакль для разного");
        this.addItem(OccultismItems.REPAIR_ICON, "Иконка починки");
        this.addItem(OccultismItems.RESURRECT_ICON, "Иконка воскресения");
		this.addItem(OccultismItems.MYSTERIOUS_EGG_ICON, "Иконка таинственного яйца");
        this.addItem(OccultismItems.DEBUG_WAND, "Жезл отладки");
        this.addItem(OccultismItems.DEBUG_FOLIOT_LUMBERJACK, "Вызов отладочного Фолиота-Дровосека");
        this.addItem(OccultismItems.DEBUG_FOLIOT_TRANSPORT_ITEMS, "Вызов отладочного Фолиота-Транспортировщика");
        this.addItem(OccultismItems.DEBUG_FOLIOT_CLEANER, "Вызов отладочного Фолиота-Дворника");
        this.addItem(OccultismItems.DEBUG_FOLIOT_TRADER_ITEM, "Вызов отладочного Фолиота-Торговца");
        this.addItem(OccultismItems.DEBUG_DJINNI_MANAGE_MACHINE, "Вызов отладочного Джинна-Станочника");
        this.addItem(OccultismItems.DEBUG_DJINNI_TEST, "Вызов отладочного тестового Джинна");
        this.addAutoTooltip(OccultismItems.DIVINATION_ROD.get(),
                """
                        Ничего не видите?
                        Ознакомьтесь со страницей «Устранение проблем» в Справочнике душ!
                        Найдите иконку Стержня прорицания во вкладке "Начало работы".
                        """
        );
        this.addItem(OccultismItems.RITUAL_SATCHEL_T1, "Ритуальная наплечная сумка подмастерья");
        this.addAutoTooltip(OccultismItems.RITUAL_SATCHEL_T1.get(),
                """
                        Обычная ритуальная наплечная сумка может помещать ритуальные круги поблочно.
                        Нажмите ПКМ по предосмотренному блоку, чтобы поставить его из наплечной сумки.
                        Нажмите Shift + ПКМ, чтобы открыть наплечную сумку и добавить ингредиенты для ритуала.
						Если внутри сумки находится предмет с менее 40% прочности, то мерцание прекратится.
                        """
        );
        this.addItem(OccultismItems.RITUAL_SATCHEL_T2, "Ремесленная ритуальная наплечная сумка");
        this.addAutoTooltip(OccultismItems.RITUAL_SATCHEL_T2.get(),
                """
                        Улучшенная ритуальная наплечная сумка может помещать целые ритуальные круги сразу.
                        Нажмите ПКМ по какому-либо предосмотренному блоку, чтобы поместить все блоки из наплечной сумки.
                        Нажмите Shift + ПКМ, чтобы открыть наплечную сумку и добавить ингредиенты для ритуала.
                        Нажмите ПКМ по золотой жертвенной миске, чтобы убрать ритуальный круг и собрать ингредиенты.
						Если внутри сумки находится предмет с менее 40% прочности, то мерцание прекратится.
                        """
        );

        this.add(TranslationKeys.RITUAL_SATCHEL_NO_PREVIEW_IN_WORLD, "Вам необходимо предварительно просмотреть пентакль, используя Справочника душ.");
        this.add(TranslationKeys.RITUAL_SATCHEL_NO_PREVIEW_BLOCK_TARGETED, "Вам необходимо нацелиться ритуальной наплечной сумкой по предосмотренному блоку.");
        this.add(TranslationKeys.RITUAL_SATCHEL_NO_VALID_ITEM_IN_SATCHEL, "В наплечной сумке нет допустимого предмета для этого предосмотренного блока.");

        this.addItem(OccultismItems.CHALK_YELLOW, "Жёлтый мел");
        this.addItem(OccultismItems.CHALK_PURPLE, "Пурпурный мел");
        this.addItem(OccultismItems.CHALK_RED, "Красный мел");
        this.addItem(OccultismItems.CHALK_WHITE, "Белый мел");
		this.addItem(OccultismItems.CHALK_LIGHT_GRAY, "Светло-серый мел");
        this.addItem(OccultismItems.CHALK_GRAY, "Серый мел");
        this.addItem(OccultismItems.CHALK_BLACK, "Чёрный мел");
        this.addItem(OccultismItems.CHALK_BROWN, "Коричневый мел");
        this.addItem(OccultismItems.CHALK_ORANGE, "Оранжевый мел");
        this.addItem(OccultismItems.CHALK_LIME, "Лаймовый мел");
        this.addItem(OccultismItems.CHALK_GREEN, "Зелёный мел");
        this.addItem(OccultismItems.CHALK_CYAN, "Бирюзовый мел");
        this.addItem(OccultismItems.CHALK_LIGHT_BLUE, "Голубой мел");
        this.addItem(OccultismItems.CHALK_BLUE, "Синий мел");
        this.addItem(OccultismItems.CHALK_MAGENTA, "Фиолетовый мел");
        this.addItem(OccultismItems.CHALK_PINK, "Розовый мел");
		this.addItem(OccultismItems.CHALK_RAINBOW, "Радужный мел");
        this.addItem(OccultismItems.CHALK_VOID, "Пустотный мел");
        this.addItem(OccultismItems.CHALK_YELLOW_IMPURE, "Осквернённый жёлтый мел");
        this.addItem(OccultismItems.CHALK_PURPLE_IMPURE, "Осквернённый пурпурный мел");
        this.addItem(OccultismItems.CHALK_RED_IMPURE, "Осквернённый красный мел");
        this.addItem(OccultismItems.CHALK_WHITE_IMPURE, "Осквернённый белый мел");
		this.addItem(OccultismItems.CHALK_LIGHT_GRAY_IMPURE, "Осквернённый светло-серый мел");
        this.addItem(OccultismItems.CHALK_GRAY_IMPURE, "Осквернённый серый мел");
        this.addItem(OccultismItems.CHALK_BLACK_IMPURE, "Осквернённый чёрный мел");
        this.addItem(OccultismItems.CHALK_BROWN_IMPURE, "Осквернённый коричневый мел");
        this.addItem(OccultismItems.CHALK_ORANGE_IMPURE, "Осквернённый оранжевый мел");
        this.addItem(OccultismItems.CHALK_LIME_IMPURE, "Осквернённый лаймовый мел");
        this.addItem(OccultismItems.CHALK_GREEN_IMPURE, "Осквернённый зелёный мел");
        this.addItem(OccultismItems.CHALK_CYAN_IMPURE, "Осквернённый бирюзовый мел");
        this.addItem(OccultismItems.CHALK_LIGHT_BLUE_IMPURE, "Осквернённый голубой мел");
        this.addItem(OccultismItems.CHALK_BLUE_IMPURE, "Осквернённый синий мел");
        this.addItem(OccultismItems.CHALK_MAGENTA_IMPURE, "Осквернённый фиолетовый мел");
        this.addItem(OccultismItems.CHALK_PINK_IMPURE, "Осквернённый розовый мел");
        this.addItem(OccultismItems.BRUSH, "Щётка для мела");
        this.addItem(OccultismItems.AFRIT_ESSENCE, "Сущность Африта");
        this.addItem(OccultismItems.PURIFIED_INK, "Очищенные чернила");
        this.addItem(OccultismItems.AWAKENED_FEATHER, "Пробуждённое перо");
        this.addItem(OccultismItems.TABOO_BOOK, "Книга табу");
        this.addItem(OccultismItems.BOOK_OF_BINDING_EMPTY, "Пустая книга привязки");
        this.addItem(OccultismItems.BOOK_OF_BINDING_FOLIOT, "Книга привязки: Фолиот");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_FOLIOT, "Книга привязки: Фолиот (связанная)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_DJINNI, "Книга привязки: Джинн");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_DJINNI, "Книга привязки: Джинн (связанная)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_AFRIT, "Книга привязки: Африт");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_AFRIT, "Книга привязки: Африт (связанная)");
        this.addItem(OccultismItems.BOOK_OF_BINDING_MARID, "Книга привязки: Марид");
        this.addItem(OccultismItems.BOOK_OF_BINDING_BOUND_MARID, "Книга привязки: Марид (связанная)");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_LUMBERJACK, "Книга вызова: Фолиот-Дровосек");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_TRANSPORT_ITEMS, "Книга вызова: Фолиот-Транспортировщик");
        this.addItem(OccultismItems.BOOK_OF_CALLING_FOLIOT_CLEANER, "Книга вызова: Фолиот-Дворник");
        this.addItem(OccultismItems.BOOK_OF_CALLING_DJINNI_MANAGE_MACHINE, "Книга вызова: Джинн-Станочник");
        this.addItem(OccultismItems.STORAGE_REMOTE, "Средство доступа хранилища");
        this.addItem(OccultismItems.STORAGE_REMOTE_INERT, "Инертное средство доступа хранилища");
        this.addItem(OccultismItems.DIMENSIONAL_MATRIX, "Кристалл пространственной матрицы");
        this.addItem(OccultismItems.DIVINATION_ROD, "Жезл прорицания");
        this.addItem(OccultismItems.DATURA_SEEDS, "Семена видения демона");
        this.addAutoTooltip(OccultismItems.DATURA_SEEDS.get(), "Посадите, чтобы вырастить Плод видения демона.\nУпотребление позволяет видеть за гробовой чертой... может также вызвать плохое самочувствие.");
        this.addItem(OccultismItems.DATURA, "Плод видения демона");
        this.addAutoTooltip(OccultismItems.DATURA.get(), "Употребление позволяет видеть за гробовой чертой... может также вызвать плохое самочувствие.");
        this.addItem(OccultismItems.DEMONS_DREAM_ESSENCE, "Эссенция видения демона");
        this.addAutoTooltip(OccultismItems.DEMONS_DREAM_ESSENCE.get(), "Употребление позволяет видеть за гробовой чертой... и полный набор других эффектов.");
        this.addItem(OccultismItems.OTHERWORLD_ESSENCE, "Потусторонняя эссенция");
        this.addAutoTooltip(OccultismItems.OTHERWORLD_ESSENCE.get(), "Очищенная эссенция видения демона больше не оказывает пагубные эффекты.");
        this.addItem(OccultismItems.BEAVER_NUGGET, "Мех бобра");
        this.addItem(OccultismItems.SPIRIT_ATTUNED_GEM, "Самоцвет, настроенный на духа");
        this.lang("ru_ru").add("item.occultism.otherworld_sapling", "Потусторонний саженец");
        this.lang("ru_ru").add("item.occultism.otherworld_sapling_natural", "Нестабильный потусторонний саженец");
        this.addItem(OccultismItems.OTHERWORLD_ASHES, "Потусторонняя зола");
        this.addItem(OccultismItems.BURNT_OTHERSTONE, "Гарь из потустороннего камня");
        this.addItem(OccultismItems.BUTCHER_KNIFE, "Нож мясника");
        this.addItem(OccultismItems.TALLOW, "Жир");
        this.addItem(OccultismItems.OTHERSTONE_FRAME, "Рама из потустороннего камня");
        this.addItem(OccultismItems.OTHERSTONE_TABLET, "Дощечка из потустороннего камня");
        this.addItem(OccultismItems.WORMHOLE_FRAME, "Рама червоточины");
        this.addItem(OccultismItems.IRON_DUST, "Железная пыль");
        this.addItem(OccultismItems.OBSIDIAN_DUST, "Обсидиановая пыль");
        this.addItem(OccultismItems.CRUSHED_END_STONE, "Измельчённый эндерняк");
        this.addItem(OccultismItems.GOLD_DUST, "Золотая пыль");
        this.addItem(OccultismItems.COPPER_DUST, "Медная пыль");
        this.addItem(OccultismItems.SILVER_DUST, "Серебряная пыль");
        this.addItem(OccultismItems.IESNIUM_DUST, "Айзниевая пыль");
        this.addItem(OccultismItems.RAW_SILVER, "Рудное серебро");
        this.addItem(OccultismItems.RAW_IESNIUM, "Рудный айзний");
        this.addItem(OccultismItems.SILVER_INGOT, "Серебряный слиток");
        this.addItem(OccultismItems.IESNIUM_INGOT, "Айзниевый слиток");
        this.addItem(OccultismItems.SILVER_NUGGET, "Кусочек серебра");
        this.addItem(OccultismItems.IESNIUM_NUGGET, "Кусочек айзния");
        this.addItem(OccultismItems.LENSES, "Линзы");
        this.addItem(OccultismItems.INFUSED_LENSES, "Наполненные линзы");
        this.addItem(OccultismItems.LENS_FRAME, "Оправа для очков");
        this.addItem(OccultismItems.OTHERWORLD_GOGGLES, "Потусторонние очки");
        this.addItem(OccultismItems.INFUSED_PICKAXE, "Наполненная кирка");
        this.addItem(OccultismItems.SPIRIT_ATTUNED_PICKAXE_HEAD, "Головка кирки из самоцвета, настроенного на духа");
        this.addItem(OccultismItems.IESNIUM_PICKAXE, "Айзниевая кирка");
        this.addItem(OccultismItems.MAGIC_LAMP_EMPTY, "Пустая магическая лампа");
        this.addItem(OccultismItems.MINER_FOLIOT_UNSPECIALIZED, "Фолиот-Рудокоп");
        this.addItem(OccultismItems.MINER_DJINNI_ORES, "Рудный Джинн-Рудокоп");
        this.addItem(OccultismItems.MINER_DEBUG_UNSPECIALIZED, "Отладочный рудокоп");
        this.addItem(OccultismItems.MINER_AFRIT_DEEPS, "Африт-Рудокоп для глубинносланцевой руды");
        this.addItem(OccultismItems.MINER_MARID_MASTER, "Мастер Марид-Рудокоп");
		this.addItem(OccultismItems.MINER_ANCIENT_ELDRITCH, "Сверхъестественный древний рудокоп");
        this.addItem(OccultismItems.MINING_DIMENSION_CORE_PIECE, "Часть ядра шахтёрского измерения");
        this.addItem(OccultismItems.SOUL_GEM_ITEM, "Камень душ");
        this.lang("ru_ru").add(OccultismItems.SOUL_GEM_ITEM.get().getDescriptionId() + "_empty", "Пустой камень душ");
		this.addItem(OccultismItems.TRINITY_GEM_ITEM, "Камень Троицы");
        this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + "_empty", "Пустой камень Троицы");
		this.add(OccultismItems.TRINITY_GEM_ITEM.get().getDescriptionId() + ".message.entity_type_denied", "Камни Троицы не могут содержать этот тип существа");
        this.addItem(OccultismItems.SOUL_SHARD_ITEM, "Осколок души");
        this.addItem(OccultismItems.SATCHEL, "Необычайно большая сумка");
        this.addItem(OccultismItems.FAMILIAR_RING, "Кольцо для фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_FOLIOT, "Яйцо призыва Фолиота");
        this.addItem(OccultismItems.SPAWN_EGG_DJINNI, "Яйцо призыва Джинна");
        this.addItem(OccultismItems.SPAWN_EGG_AFRIT, "Яйцо призыва Африта");
        this.addItem(OccultismItems.SPAWN_EGG_AFRIT_UNBOUND, "Яйцо призыва незаточённого Африта");
        this.addItem(OccultismItems.SPAWN_EGG_MARID, "Яйцо призыва Марида");
		this.addItem(OccultismItems.SPAWN_EGG_MARID_UNBOUND, "Яйцо призыва незаточённого Марида");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ENDERMITE, "Яйцо призыва Одержимого эндермита");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_SKELETON, "Яйцо призыва Одержимого скелета");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ENDERMAN, "Яйцо призыва Одержимого эндермена");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_GHAST, "Яйцо призыва Одержимого гаста");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_PHANTOM, "Яйцо призыва Одержимого фантома");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WEAK_SHULKER, "Яйцо призыва Одержимого слабого шалкера");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_SHULKER, "Яйцо призыва Одержимого шалкера");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ELDER_GUARDIAN, "Яйцо призыва Одержимого древнего стража");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WARDEN, "Яйцо призыва Одержимого хранителя");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_HOGLIN, "Яйцо призыва Одержимого хоглина");
		this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_WITCH, "Яйцо призыва Одержимой ведьмы");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_ZOMBIE_PIGLIN, "Яйцо призыва Одержимого зомбифицированного пиглина");
        this.addItem(OccultismItems.SPAWN_EGG_POSSESSED_BEE, "Яйцо призыва Одержимой пчелы");
		this.addItem(OccultismItems.SPAWN_EGG_GOAT_OF_MERCY, "Яйцо призыва Козла милосердия");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HUNT_SKELETON, "Яйцо призыва скелета Дикой Охоты");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HUNT_WITHER_SKELETON, "Яйцо призыва визер скелета Дикой Охоты");
        this.addItem(OccultismItems.SPAWN_EGG_OTHERWORLD_BIRD, "Яйцо призыва Дрикрыла");
        this.addItem(OccultismItems.SPAWN_EGG_GREEDY_FAMILIAR, "Яйцо призыва Алчного фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_BAT_FAMILIAR, "Яйцо призыва Летучей мыши-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_DEER_FAMILIAR, "Яйцо призыва Оленя-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_CTHULHU_FAMILIAR, "Яйцо призыва Ктулху-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_DEVIL_FAMILIAR, "Яйцо призыва Дьявола-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_DRAGON_FAMILIAR, "Яйцо призыва Дракона-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_BLACKSMITH_FAMILIAR, "Яйцо призыва Кузнеца-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_GUARDIAN_FAMILIAR, "Яйцо призыва Стража-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_HEADLESS_FAMILIAR, "Яйцо призыва Безголового человека-крысы-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_CHIMERA_FAMILIAR, "Яйцо призыва Химеры-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_GOAT_FAMILIAR, "Яйцо призыва Козы-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_SHUB_NIGGURATH_FAMILIAR, "Яйцо призыва Шуб-Ниггурата-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_BEHOLDER_FAMILIAR, "Яйцо призыва Созерцателя-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_FAIRY_FAMILIAR, "Яйцо призыва Феи-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_MUMMY_FAMILIAR, "Яйцо призыва Мумии-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_BEAVER_FAMILIAR, "Яйцо призыва Бобра-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_PARROT_FAMILIAR, "Яйцо призыва Попугая-фамильяра");
        this.addItem(OccultismItems.SPAWN_EGG_DEMONIC_WIFE, "Яйцо призыва Демонической жены");
        this.addItem(OccultismItems.SPAWN_EGG_DEMONIC_HUSBAND, "Яйцо призыва Демонического мужа");
		this.addItem(OccultismItems.SPAWN_EGG_IESNIUM_GOLEM, "Яйцо призыва Айзниевого голема");
		this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_HUSK, "Яйцо призыва Орды диких кадавров");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_DROWNED, "Яйцо призыва Орды диких утопленников");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_CREEPER, "Яйцо призыва Орды диких криперов");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_HORDE_SILVERFISH, "Яйцо призыва Орды диких чешуйниц");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_WEAK_BREEZE, "Яйцо призыва Одержимого слабого вихря");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_BREEZE, "Яйцо призыва Одержимого вихря");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_STRONG_BREEZE, "Яйцо призыва Одержимого сильного вихря");
        this.addItem(OccultismItems.SPAWN_EGG_WILD_EVOKER, "Яйцо призыва Одержимого заклинателя");
		//Обновление: Переработка пентаклей
        this.addItem(OccultismItems.AMETHYST_DUST, "Аметистовая пыль");
        this.addItem(OccultismItems.CRUELTY_ESSENCE, "Сущность бессердечия");
        this.addItem(OccultismItems.CRUSHED_BLACKSTONE, "Измельчённый чернит");
        this.addItem(OccultismItems.CRUSHED_BLUE_ICE, "Измельчённый синий лёд");
		this.addItem(OccultismItems.CRUSHED_CALCITE, "Измельчённый кальцит");
        this.addItem(OccultismItems.CRUSHED_ICE, "Измельчённый лёд");
        this.addItem(OccultismItems.CRUSHED_PACKED_ICE, "Измельчённый плотный лёд");
        this.addItem(OccultismItems.CURSED_HONEY, "Проклятый мёд");
        this.addItem(OccultismItems.DEMONIC_MEAT, "Демоническое мясо");
        this.addItem(OccultismItems.DRAGONYST_DUST, "Драконистовая пыль");
        this.addItem(OccultismItems.ECHO_DUST, "Пыль эхо");
        this.addItem(OccultismItems.EMERALD_DUST, "Изумрудная пыль");
        this.addItem(OccultismItems.GRAY_PASTE, "Серая паста");
        this.addItem(OccultismItems.LAPIS_DUST, "Лазуритовая пыль");
        this.addItem(OccultismItems.MARID_ESSENCE, "Сущность Марида");
        this.addItem(OccultismItems.NATURE_PASTE, "Природная паста");
        this.addItem(OccultismItems.NETHERITE_DUST, "Незеритовая пыль");
        this.addItem(OccultismItems.NETHERITE_SCRAP_DUST, "Пыль из незеритового обломка");
        this.addItem(OccultismItems.RESEARCH_FRAGMENT_DUST, "Пыль фрагмента исследования");
        this.addItem(OccultismItems.WITHERITE_DUST, "Визеритовая пыль");
    }

    private void addBlocks() {
        //"block\.occultism\.(.*?)": "(.*)",
        //this.addBlock\(OccultismItems.\U\1\E, "\2"\);
		this.addBlock(OccultismBlocks.OTHERGLASS, "Потустороннее стекло");
        this.addBlock(OccultismBlocks.OTHERSTONE, "Потусторонний камень");
		this.addBlock(OccultismBlocks.OTHERSTONE_STAIRS, "Ступеньки из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_SLAB, "Плита из потустороннего камня");
		this.addBlock(OccultismBlocks.OTHERSTONE_PRESSURE_PLATE, "Нажимная плита из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_BUTTON, "Кнопка из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_WALL, "Ограда из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE, "Потусторонний булыжник");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_STAIRS, "Ступеньки из потустороннего булыжника");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_SLAB, "Плита из потустороннего булыжника");
        this.addBlock(OccultismBlocks.OTHERCOBBLESTONE_WALL, "Ограда из потустороннего булыжника");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE, "Полированный потусторонний камень");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_STAIRS, "Полированные ступеньки из потустороннего камня");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_SLAB, "Полированная плита из потустороннего камня");
        this.addBlock(OccultismBlocks.POLISHED_OTHERSTONE_WALL, "Полированная ограда из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS, "Кирпичи из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_STAIRS, "Кирпичные ступеньки из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_SLAB, "Кирпичная плита из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_BRICKS_WALL, "Кирпичная ограда из потустороннего камня");
        this.addBlock(OccultismBlocks.CHISELED_OTHERSTONE_BRICKS, "Резные кирпичи из потустороннего камня");
        this.addBlock(OccultismBlocks.CRACKED_OTHERSTONE_BRICKS, "Потрескавшиеся кирпичи из потустороннего камня");
        this.addBlock(OccultismBlocks.OTHERSTONE_PEDESTAL, "Потусторонний пьедестал");
		this.addBlock(OccultismBlocks.OTHERSTONE_PEDESTAL_SILVER, "Серебряный пьедестал из потустороннего камня");
        this.addBlock(OccultismBlocks.SACRIFICIAL_BOWL, "Жертвенная миска");
		this.addBlock(OccultismBlocks.COPPER_SACRIFICIAL_BOWL, "Медная жертвенная миска");
        this.addBlock(OccultismBlocks.SILVER_SACRIFICIAL_BOWL, "Серебряная жертвенная миска");
        this.addBlock(OccultismBlocks.GOLDEN_SACRIFICIAL_BOWL, "Золотая жертвенная миска");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_WHITE, "Белый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_YELLOW, "Жёлтый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_PURPLE, "Пурпурный глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_RED, "Красный глиф");
		this.addBlock(OccultismBlocks.CHALK_GLYPH_LIGHT_GRAY, "Светло-серый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_GRAY, "Серый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BLACK, "Чёрный глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BROWN, "Коричневый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_ORANGE, "Оранжевый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_LIME, "Лаймовый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_GREEN, "Зелёный глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_CYAN, "Бирюзовый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_LIGHT_BLUE, "Голубой глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_BLUE, "Синий глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_MAGENTA, "Фиолетовый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_PINK, "Розовый глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_RAINBOW, "Радужный глиф");
        this.addBlock(OccultismBlocks.CHALK_GLYPH_VOID, "Пустотный глиф");
        this.addBlock(OccultismBlocks.STORAGE_CONTROLLER, "Регулятор пространственного хранилища");
		this.addBlock(OccultismBlocks.STORAGE_CONTROLLER_STABILIZED, "Регулятор стабилизатора пространственного хранилища");
        this.addBlock(OccultismBlocks.STORAGE_CONTROLLER_BASE, "Основание актуатора хранилища");
		this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER0, "Основание стабилизатора пространственного хранилища");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER1, "Стабилизатор пространственного хранилища 1-го уровня");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER2, "Стабилизатор пространственного хранилища 2-го уровня");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER3, "Стабилизатор пространственного хранилища 3-го уровня");
        this.addBlock(OccultismBlocks.STORAGE_STABILIZER_TIER4, "Стабилизатор пространственного хранилища 4-го уровня");
        this.addBlock(OccultismBlocks.STABLE_WORMHOLE, "Стабильная червоточина");
        this.addBlock(OccultismBlocks.DATURA, "Видение демона");
		this.addBlock(OccultismBlocks.OTHERFLOWER, "Потусторонний цветок");
        this.addBlock(OccultismBlocks.OTHERWORLD_SAPLING, "Потусторонний саженец");
        this.addBlock(OccultismBlocks.OTHERWORLD_LEAVES, "Потусторонние листья");
		this.addBlock(OccultismBlocks.OTHERWORLD_LOG, "Потустороннее бревно");
        this.addBlock(OccultismBlocks.OTHERWORLD_WOOD, "Потусторонняя древесина");
        this.addBlock(OccultismBlocks.STRIPPED_OTHERWORLD_LOG, "Обтёсанное потустороннее бревно");
        this.addBlock(OccultismBlocks.STRIPPED_OTHERWORLD_WOOD, "Обтёсанная потусторонняя древесина");
        this.addBlock(OccultismBlocks.OTHERPLANKS, "Потусторонние доски");
        this.addBlock(OccultismBlocks.OTHERPLANKS_STAIRS, "Ступеньки из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_SLAB, "Плита из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_FENCE, "Забор из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_FENCE_GATE, "Калитка из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_DOOR, "Дверь из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_TRAPDOOR, "Люк из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_PRESSURE_PLATE, "Нажимная плита из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_BUTTON, "Кнопка из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_SIGN, "Табличка из потусторонних досок");
        this.addBlock(OccultismBlocks.OTHERPLANKS_HANGING_SIGN, "Навесная табличка из потусторонних досок");

		this.addBlock(OccultismBlocks.TALLOW_BLOCK, "Блок жира");
        this.addBlock(OccultismBlocks.SPIRIT_FIRE, "Духовный огонь");
        this.addBlock(OccultismBlocks.SPIRIT_ATTUNED_CRYSTAL, "Кристалл, настроенный на духа");
		this.addBlock(OccultismBlocks.LARGE_CANDLE, "Большая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_WHITE, "Большая белая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIGHT_GRAY, "Большая светло-серая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_GRAY, "Большая серая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BLACK, "Большая чёрная свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BROWN, "Большая коричневая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_RED, "Большая красная свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_ORANGE, "Большая оранжевая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_YELLOW, "Большая жёлтая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIME, "Большая лаймовая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_GREEN, "Большая зелёная свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_CYAN, "Большая бирюзовая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_BLUE, "Большая синяя свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_LIGHT_BLUE, "Большая голубая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_PINK, "Большая розовая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_MAGENTA, "Большая фиолетовая свеча");
        this.addBlock(OccultismBlocks.LARGE_CANDLE_PURPLE, "Большая пурпурная свеча");
        this.addBlock(OccultismBlocks.SILVER_ORE, "Серебряная руда");
        this.addBlock(OccultismBlocks.SILVER_ORE_DEEPSLATE, "Сереброносная глубинносланцевая руда");
		this.addBlock(OccultismBlocks.IESNIUM_ANVIL, "Айзниевая наковальня");
        this.addBlock(OccultismBlocks.IESNIUM_ORE, "Руда айзния");
        this.addBlock(OccultismBlocks.SILVER_BLOCK, "Серебряный блок");
        this.addBlock(OccultismBlocks.IESNIUM_BLOCK, "Блок айзния");
		this.addBlock(OccultismBlocks.IESNIUM_SACRIFICIAL_BOWL, "Айзниевая жертвенная миска");
        this.addBlock(OccultismBlocks.RAW_SILVER_BLOCK, "Блок рудного серебра");
        this.addBlock(OccultismBlocks.RAW_IESNIUM_BLOCK, "Блок рудного айзния");
        this.addBlock(OccultismBlocks.DIMENSIONAL_MINESHAFT, "Пространственная шахта");
        this.addBlock(OccultismBlocks.SKELETON_SKULL_DUMMY, "Череп скелета");
        this.addBlock(OccultismBlocks.WITHER_SKELETON_SKULL_DUMMY, "Череп визер-скелета");
        this.addBlock(OccultismBlocks.LIGHTED_AIR, "Подсвеченный воздух");
        this.addBlock(OccultismBlocks.SPIRIT_LANTERN, "Духовный фонарь");
        this.addBlock(OccultismBlocks.SPIRIT_CAMPFIRE, "Духовный костёр");
        this.addBlock(OccultismBlocks.SPIRIT_TORCH, "Духовный факел"); //Настенный духовный факел автоматически использует такой же перевод.
		this.addBlock(OccultismBlocks.ELDRITCH_CHALICE, "Сверхъестественный потир");
    }

    private void addEntities() {
        //"entity\.occultism\.(.*?)": "(.*)",
        //this.addEntityType\(OccultismEntities.\U\1\E, "\2"\);

        this.addEntityType(OccultismEntities.FOLIOT, "Фолиот");
        this.addEntityType(OccultismEntities.DJINNI, "Джинн");
        this.addEntityType(OccultismEntities.AFRIT, "Африт");
        this.addEntityType(OccultismEntities.AFRIT_WILD, "Незаточённый Африт");
        this.addEntityType(OccultismEntities.MARID, "Марид");
        this.addEntityType(OccultismEntities.MARID_UNBOUND, "Незаточённый Марид");
        this.addEntityType(OccultismEntities.POSSESSED_ENDERMITE, "Одержимый эндермит");
        this.addEntityType(OccultismEntities.POSSESSED_SKELETON, "Одержимый скелет");
        this.addEntityType(OccultismEntities.POSSESSED_ENDERMAN, "Одержимый эндермен");
        this.addEntityType(OccultismEntities.POSSESSED_GHAST, "Одержимый гаст");
        this.addEntityType(OccultismEntities.POSSESSED_PHANTOM, "Одержимый фантом");
        this.addEntityType(OccultismEntities.POSSESSED_WEAK_SHULKER, "Одержимый слабый шалкер");
        this.addEntityType(OccultismEntities.POSSESSED_SHULKER, "Одержимый шалкер");
        this.addEntityType(OccultismEntities.POSSESSED_ELDER_GUARDIAN, "Одержимый древний страж");
        this.addEntityType(OccultismEntities.POSSESSED_WARDEN, "Одержимый хранитель");
        this.addEntityType(OccultismEntities.POSSESSED_HOGLIN, "Одержимый хоглин");
		this.addEntityType(OccultismEntities.POSSESSED_WITCH, "Одержимая ведьма");
        this.addEntityType(OccultismEntities.POSSESSED_ZOMBIE_PIGLIN, "Одержимый зомбифицированный пиглин");
        this.addEntityType(OccultismEntities.POSSESSED_BEE, "Одержимая пчела");
		this.addEntityType(OccultismEntities.GOAT_OF_MERCY, "Козёл милосердия");
        this.addEntityType(OccultismEntities.WILD_HUNT_SKELETON, "Скелет Дикой Охоты");
        this.addEntityType(OccultismEntities.WILD_HUNT_WITHER_SKELETON, "Визер-скелет Дикой Охоты");
        this.addEntityType(OccultismEntities.OTHERWORLD_BIRD, "Дрикрыл");
        this.addEntityType(OccultismEntities.GREEDY_FAMILIAR, "Алчный фамильяр");
        this.addEntityType(OccultismEntities.BAT_FAMILIAR, "Летучая мышь-фамильяр");
        this.addEntityType(OccultismEntities.DEER_FAMILIAR, "Олень-фамильяр");
        this.addEntityType(OccultismEntities.CTHULHU_FAMILIAR, "Ктулху-фамильяр");
        this.addEntityType(OccultismEntities.DEVIL_FAMILIAR, "Дьявол-фамильяр");
        this.addEntityType(OccultismEntities.DRAGON_FAMILIAR, "Дракон-фамильяр");
        this.addEntityType(OccultismEntities.BLACKSMITH_FAMILIAR, "Кузнец-фамильяр");
        this.addEntityType(OccultismEntities.GUARDIAN_FAMILIAR, "Страж-фамильяр");
        this.addEntityType(OccultismEntities.HEADLESS_FAMILIAR, "Безголовый-фамильяр");
        this.addEntityType(OccultismEntities.CHIMERA_FAMILIAR, "Химера-фамильяр");
        this.addEntityType(OccultismEntities.GOAT_FAMILIAR, "Козёл-фамильяр");
        this.addEntityType(OccultismEntities.SHUB_NIGGURATH_FAMILIAR, "Шуб-Ниггурат-фамильяр");
        this.addEntityType(OccultismEntities.BEHOLDER_FAMILIAR, "Созерцатель-фамильяр");
        this.addEntityType(OccultismEntities.FAIRY_FAMILIAR, "Фея-фамильяр");
        this.addEntityType(OccultismEntities.MUMMY_FAMILIAR, "Мумия-фамильяр");
        this.addEntityType(OccultismEntities.BEAVER_FAMILIAR, "Бобёр-фамильяр");
        this.addEntityType(OccultismEntities.SHUB_NIGGURATH_SPAWN, "Потомок Шуб-Ниггурата");
        this.addEntityType(OccultismEntities.THROWN_SWORD, "Брошенный меч");
        this.addEntityType(OccultismEntities.DEMONIC_WIFE, "Демоническая жена");
        this.addEntityType(OccultismEntities.DEMONIC_HUSBAND, "Демонический муж");
		this.addEntityType(OccultismEntities.IESNIUM_GOLEM, "Айзниевый голем");
        this.addEntityType(OccultismEntities.WILD_HORDE_HUSK, "Орда диких кадавров");
        this.addEntityType(OccultismEntities.WILD_HORDE_DROWNED, "Орда диких утопленников");
        this.addEntityType(OccultismEntities.WILD_HORDE_CREEPER, "Орда диких криперов");
        this.addEntityType(OccultismEntities.WILD_HORDE_SILVERFISH, "Орда диких чешуйниц");
        this.addEntityType(OccultismEntities.POSSESSED_WEAK_BREEZE, "Одержимый слабый вихрь");
        this.addEntityType(OccultismEntities.POSSESSED_BREEZE, "Одержимый вихрь");
        this.addEntityType(OccultismEntities.POSSESSED_STRONG_BREEZE, "Одержимый сильный вихрь");
        this.addEntityType(OccultismEntities.WILD_ZOMBIE, "Дикий зомби");
        this.addEntityType(OccultismEntities.WILD_SKELETON, "Дикий скелет");
        this.addEntityType(OccultismEntities.WILD_SILVERFISH, "Дикая чешуйница");
        this.addEntityType(OccultismEntities.WILD_SPIDER, "Дикий паук");
        this.addEntityType(OccultismEntities.WILD_BOGGED, "Дикий болотник");
        this.addEntityType(OccultismEntities.WILD_SLIME, "Дикий слизень");
        this.addEntityType(OccultismEntities.WILD_HUSK, "Дикий кадавр");
        this.addEntityType(OccultismEntities.WILD_STRAY, "Дикий зимогор");
        this.addEntityType(OccultismEntities.WILD_CAVE_SPIDER, "Дикий пещерный паук");
        this.addEntityType(OccultismEntities.POSSESSED_EVOKER, "Одержимый заклинатель");
    }

    private void addMiscTranslations() {

        //"(.*?)": "(.*)",
        //this.lang("ru_ru").add\("\1", "\2"\);

        this.lang("ru_ru").add(TranslationKeys.HUD_NO_PENTACLE_FOUND, "Допустимый пентакль не найден.");
        this.lang("ru_ru").add(TranslationKeys.HUD_PENTACLE_FOUND, "Текущий пентакль: %s");

        this.lang("ru_ru").add(TranslationKeys.MESSAGE_CONTAINER_ALREADY_OPEN, "Этот контейнер уже открыт другим игроком, ждите пока он его не запрёт.");

        //Должности
        this.lang("ru_ru").add("job.occultism.lumberjack", "Дровосек");
        this.lang("ru_ru").add("job.occultism.crush_tier1", "Медленный дробильщик");
        this.lang("ru_ru").add("job.occultism.crush_tier2", "Дробильщик");
        this.lang("ru_ru").add("job.occultism.crush_tier3", "Быстрый дробильщик");
        this.lang("ru_ru").add("job.occultism.crush_tier4", "Очень быстрый дробильщик");
		this.lang("ru_ru").add("job.occultism.smelt_tier1", "Медленный литейщик");
        this.lang("ru_ru").add("job.occultism.smelt_tier2", "Литейщик");
        this.lang("ru_ru").add("job.occultism.smelt_tier3", "Быстрый литейщик");
        this.lang("ru_ru").add("job.occultism.smelt_tier4", "Очень быстрый литейщик");
        this.lang("ru_ru").add("job.occultism.manage_machine", "Станочник");
        this.lang("ru_ru").add("job.occultism.transport_items", "Транспортировщик");
        this.lang("ru_ru").add("job.occultism.cleaner", "Дворник");
        this.lang("ru_ru").add("job.occultism.trade_otherstone_t1", "Торговец потусторонним камнем");
        this.lang("ru_ru").add("job.occultism.trade_otherworld_saplings_t1", "Торговец потусторонними саженцами");
        this.lang("ru_ru").add("job.occultism.clear_weather", "Дух ясной погоды");
        this.lang("ru_ru").add("job.occultism.rain_weather", "Дух дождливой погоды");
        this.lang("ru_ru").add("job.occultism.thunder_weather", "Дух грозы");
        this.lang("ru_ru").add("job.occultism.day_time", "Дух рассвета");
        this.lang("ru_ru").add("job.occultism.night_time", "Дух сумерок");

        //Перечисление
        this.lang("ru_ru").add("enum.occultism.facing.up", "Верх");
        this.lang("ru_ru").add("enum.occultism.facing.down", "Низ");
        this.lang("ru_ru").add("enum.occultism.facing.north", "Север");
        this.lang("ru_ru").add("enum.occultism.facing.south", "Юг");
        this.lang("ru_ru").add("enum.occultism.facing.west", "Запад");
        this.lang("ru_ru").add("enum.occultism.facing.east", "Восток");
        this.lang("ru_ru").add("enum.occultism.book_of_calling.item_mode.set_deposit", "Установить ввод");
        this.lang("ru_ru").add("enum.occultism.book_of_calling.item_mode.set_extract", "Установить извлечение");
        this.lang("ru_ru").add("enum.occultism.book_of_calling.item_mode.set_base", "Установить место базы");
        this.lang("ru_ru").add("enum.occultism.book_of_calling.item_mode.set_storage_controller", "Установить актуатор хранилища");
        this.lang("ru_ru").add("enum.occultism.book_of_calling.item_mode.set_managed_machine", "Установить машину");
        this.lang("ru_ru").add("enum.occultism.work_area_size.small", "16х16");
        this.lang("ru_ru").add("enum.occultism.work_area_size.medium", "32х32");
        this.lang("ru_ru").add("enum.occultism.work_area_size.large", "64х64");

        //Сообщения отладки
        this.lang("ru_ru").add("debug.occultism.debug_wand.printed_glyphs", "Глифы записаны.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.glyphs_verified", "Глифы проверены.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.glyphs_not_verified", "Глифы не проверены.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.spirit_selected", "Дух с идентификатором %s выбран.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.spirit_tamed", "Дух с идентификатором %s приручен.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.deposit_selected", "Установить блок %s для ввода: сторона %s.");
        this.lang("ru_ru").add("debug.occultism.debug_wand.no_spirit_selected", "Дух не выбран.");

        //Жертвы для ритуала
        this.lang("ru_ru").add("ritual.occultism.sacrifice.cows", "Корова");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.bats", "Летучая мышь");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.bees", "Пчела");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.zombies", "Зомби");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.parrots", "Попугай");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.chicken", "Курица");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.pigs", "Свиньи");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.humans", "Крестьянин или игрок");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.squid", "Спрут");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.horses", "Лошадь");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.sheep", "Овца");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.llamas", "Лама");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.goats", "Коза");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.snow_golem", "Снежный голем");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.iron_golem", "Железный голем");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.spiders", "Паук");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.flying_passive", "Тихоня, летучая мышь, пчела или попугай");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.cubemob", "Слизень или магмовый куб");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.fish", "Любая рыба");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.axolotls", "Аксолотль");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.camel", "Верблюд");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.dolphin", "Дельфин");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.wolfs", "Волк");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.ocelot", "Оцелот");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.cats", "Кошка");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.vex", "Вредина");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.tadpoles", "Головастик");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.allay", "Тихоня");
        this.lang("ru_ru").add("ritual.occultism.sacrifice.warden", "Хранитель");
		this.lang("ru_ru").add("ritual.occultism.sacrifice.ravager", "Разоритель");

        //Сообщение сети
        this.lang("ru_ru").add("network.messages.occultism.request_order.order_received", "Заказ получен!");

        //Эффекты
        this.lang("ru_ru").add("effect.occultism.third_eye", "Третий глаз");
        this.lang("ru_ru").add("effect.occultism.double_jump", "Мульти-прыжок");
        this.lang("ru_ru").add("effect.occultism.dragon_greed", "Алчность дракона");
        this.lang("ru_ru").add("effect.occultism.mummy_dodge", "Уклонение");
        this.lang("ru_ru").add("effect.occultism.bat_lifesteal", "Похищение жизни");
        this.lang("ru_ru").add("effect.occultism.beaver_harvest", "Бобровая жатва");
        this.lang("ru_ru").add("effect.occultism.step_height", "Высокая поступь");

        //Звуки
        this.lang("ru_ru").add("occultism.subtitle.chalk", "Начерчение мелом");
        this.lang("ru_ru").add("occultism.subtitle.brush", "Чистка щёткой");
        this.lang("ru_ru").add("occultism.subtitle.start_ritual", "Начало ритуала");
        this.lang("ru_ru").add("occultism.subtitle.tuning_fork", "Звук камертона");
        this.lang("ru_ru").add("occultism.subtitle.crunching", "Размельчение");
        this.lang("ru_ru").add("occultism.subtitle.poof", "Вжух!");

        //Типы измерений
        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.OVERWORLD.location()), "Надземный мир");
        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.NETHER.location()), "Незер");
        this.add(Util.makeDescriptionId("dimension_type", BuiltinDimensionTypes.END.location()), "Энд");
    }

    private void addGuiTranslations() {
        this.lang("ru_ru").add("gui.occultism.book_of_calling.mode", "Режим");
        this.lang("ru_ru").add("gui.occultism.book_of_calling.work_area", "Рабочая зона");
        this.lang("ru_ru").add("gui.occultism.book_of_calling.manage_machine.insert", "Сторона ввода");
        this.lang("ru_ru").add("gui.occultism.book_of_calling.manage_machine.extract", "Сторона извлечения");
        this.lang("ru_ru").add("gui.occultism.book_of_calling.manage_machine.custom_name", "Пользовательское название");

        // Spirit GUI
        this.lang("ru_ru").add("gui.occultism.spirit.age", "Распад сущности: %d%%");
        this.lang("ru_ru").add("gui.occultism.spirit.job", "%s");

        // Spirit Transporter GUI
        this.lang("ru_ru").add("gui.occultism.spirit.transporter.filter_mode", "Режим фильтра");
        this.lang("ru_ru").add("gui.occultism.spirit.transporter.filter_mode.blacklist", "Чёрный список");
        this.lang("ru_ru").add("gui.occultism.spirit.transporter.filter_mode.whitelist", "Белый список");
        this.lang("ru_ru").add("gui.occultism.spirit.transporter.tag_filter", "Введите теги для фильтрации по символам разделения \";\".\nНапример, \"c:ores;*брёвна*\".\nИспользуйте \"*\" для соответствия с любым символом, например, \"*руда*\" для соответствия с тегами руд из любого мода. Для фильтрации предметов, префикс с идентификатором предмета \"item:\", например, \"item:minecraft:chest\".");

        // Storage Controller GUI
        this.lang("ru_ru").add("gui.occultism.storage_controller.space_info_label", "%d/%d");
        this.lang("ru_ru").add("gui.occultism.storage_controller.space_info_label_new", "Заполнено: %s%%");
        this.lang("ru_ru").add("gui.occultism.storage_controller.space_info_label_types", "Типов: %s%%");
        this.lang("ru_ru").add("gui.occultism.storage_controller.shift", "Нажмите Shift для подробностей");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip@", "Префикс @: поиск по идентификатору мода.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip#", "Префикс #: поиск по подсказке предмета.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip$", "Префикс $: поиск по тегу.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_rightclick", "Очистка текста с помощью ПКМ.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_clear", "Очистка поиска.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_jei_on", "Синхронизировать поиск с JEI.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_jei_off", "Не синхронизировать поиск с JEI.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_sort_type_amount", "Сортировать по количеству.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_sort_type_name", "Сортировать по названию предмета.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_sort_type_mod", "Сортировать по названию мода.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_sort_direction_down", "Сортировать по возрастанию.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.tooltip_sort_direction_up", "Сортировать по убыванию.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.machines.tooltip@", "Префикс @: поиск по идентификатору мода.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_amount", "Сортировать по расстоянию.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_name", "Сортировать по названию машины.");
        this.lang("ru_ru").add("gui.occultism.storage_controller.search.machines.tooltip_sort_type_mod", "Сортировать по названию мода.");
    }

    private void addRitualMessages() {
        this.lang("ru_ru").add("ritual.occultism.pentacle_help", "§lНедопустимый пентакль!§r\nВы, было, пытаетесь создать пентакль: %s? Отсутствует:\n%s");
        this.lang("ru_ru").add("ritual.occultism.pentacle_help_at_glue", " на позиции ");
        this.lang("ru_ru").add("ritual.occultism.pentacle_help.no_pentacle", "§lПентакль не найден!§r\nКажется, Вы не начертили пентакль, или в Вашем пентакле отсутствуют важные элементы. Ознакомьтесь с разделом \"Ритуалы\" в Справочнике душ: требуемый пентакль будет отображён на странице ритуала в качестве гиперссылки над рецептом ритуала.");
        this.lang("ru_ru").add("ritual.occultism.ritual_help", "§lНедопустимый ритуал!§r\nВы, было, пытались выполнить ритуал: \"%s\"? Отсутствуют предметы:\n%s");
        this.lang("ru_ru").add("ritual.occultism.disabled", "Этот ритуал отключен на этом сервере.");
        this.lang("ru_ru").add("ritual.occultism.does_not_exist", "§lНеизвестный ритуал§r. Убедитесь, что пентакли и ингредиенты расположены правильно. Если Вы до сих пор не достигли желаемого результата, присоединяйтесь к нашему Discord-серверу по ссылке: https://invite.gg/klikli");
        this.lang("ru_ru").add("ritual.occultism.book_not_bound", "§lНесвязанная книга вызова§r. Перед началом ритуала, Вы должны создать эту книгу с помощью Справочника душ, для связки её с духом.");

        this.lang("ru_ru").add("ritual.occultism.unknown.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.unknown.started", "Ритуал запущен.");
        this.lang("ru_ru").add("ritual.occultism.unknown.finished", "Ритуал полностью завершился.");
        this.lang("ru_ru").add("ritual.occultism.unknown.interrupted", "Ритуал прерван.");

        this.lang("ru_ru").add("ritual.occultism.debug.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.debug.started", "Ритуал запущен.");
        this.lang("ru_ru").add("ritual.occultism.debug.finished", "Ритуал полностью завершился.");
        this.lang("ru_ru").add("ritual.occultism.debug.interrupted", "Ритуал прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_lumberjack.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_lumberjack.started", "Вызов Фолиота-Дровосека начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_lumberjack.finished", "Фолиот-Дровосек успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_lumberjack.interrupted", "Вызов Фолиота-Дровосека прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_transport_items.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_transport_items.started", "Вызов Фолиота-Транспортировщика начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_transport_items.finished", "Фолиот-Транспортировщик успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_transport_items.interrupted", "Вызов Фолиота-Транспортировщика прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_cleaner.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_cleaner.started", "Вызов Фолиота-Дворника начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_cleaner.finished", "Фолиот-Дворник успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_cleaner.interrupted", "Вызов Фолиота-Дворника прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_sapling_trader.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_sapling_trader.started", "Вызов Фолиота-Торговца потусторонними саженцами начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_sapling_trader.finished", "Фолиот-Торговец потусторонними саженцами успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_sapling_trader.interrupted", "Вызов Фолиота-Торговца потусторонними саженцами прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_otherstone_trader.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_otherstone_trader.started", "Вызов Торговца-Фолиота потустороннем камнем начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_otherstone_trader.finished", "Торговец-Фолиот потустороннем камнем успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_foliot_otherstone_trader.interrupted", "Вызов Торговца-Фолиота потустороннем камнем прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_manage_machine.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_manage_machine.started", "Вызов Джинна-Станочника начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_manage_machine.finished", "Джинн-Станочник успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_manage_machine.interrupted", "Вызов Джинна-Станочника прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_clear_weather.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_clear_weather.started", "Вызов Джинна для ясной погоды начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_clear_weather.finished", "Джинн для ясной погоды успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_clear_weather.interrupted", "Вызов Джинна для ясной погоды прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_day_time.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_day_time.started", "Вызов Джинна для установки времени на день начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_day_time.finished", "Джинн для установки времени на день успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_day_time.interrupted", "Вызов Джинна для установки времени на день прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_night_time.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_night_time.started", "Вызов Джинна для установки времени на ночь начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_night_time.finished", "Джинн для установки времени на ночь успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_djinni_night_time.interrupted", "Вызов Джинна для установки времени на ночь прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_rain_weather.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_rain_weather.started", "Вызов Африта для дождливой погоды начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_rain_weather.finished", "Африт для дождливой погоды успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_rain_weather.interrupted", "Вызов Африта для дождливой погоды прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_thunder_weather.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_thunder_weather.started", "Вызов Африта для грозы начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_thunder_weather.finished", "Африт для грозы успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_afrit_thunder_weather.interrupted", "Вызов Африта для грозы прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_afrit.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_afrit.started", "Вызов незаточённого Африта начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_afrit.finished", "Незаточённый Африт успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_afrit.interrupted", "Вызов незаточённого Африта прерван.");
		this.lang("ru_ru").add("ritual.occultism.summon_unbound_marid.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_marid.started", "Вызов незаточённого Марида начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_marid.finished", "Незаточённый Марид успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_unbound_marid.interrupted", "Вызов незаточённого Марида прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_wild_hunt.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_wild_hunt.started", "Вызов Дикой Охоты начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_wild_hunt.finished", "Дикая Охота успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.summon_wild_hunt.interrupted", "Вызов Дикой Охоты прерван.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_matrix.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_matrix.started", "Заточение Джинна в пространственную матрицу началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_matrix.finished", "Джинн успешно заточён в пространственной матрице.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_matrix.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_mineshaft.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_mineshaft.started", "Заточение Джинна в пространственную шахту началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_mineshaft.finished", "Джинн успешно заточён в пространственной шахте.");
        this.lang("ru_ru").add("ritual.occultism.craft_dimensional_mineshaft.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_controller_base.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_controller_base.started", "Заточение Фолиота в основание актуатора хранилища началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_controller_base.finished", "Фолиота успешно заточён в основание актуатора хранилища.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_controller_base.interrupted", "Заточение Фолиота прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier1.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier1.started", "Заточение Фолиота в стабилизатор хранилища началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier1.finished", "Фолиот успешно заточён в стабилизатор хранилища.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier1.interrupted", "Заточение Фолиота прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier2.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier2.started", "Заточение Джинна в стабилизатор хранилища началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier2.finished", "Джинн успешно заточён в стабилизатор хранилища.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier2.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier3.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier3.started", "Заточение Африта в стабилизатор хранилища началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier3.finished", "Африт успешно заточён в стабилизатор хранилища.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier3.interrupted", "Заточение Африта прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier4.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier4.started", "Заточение Марида в стабилизатор хранилища началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier4.finished", "Марид успешно заточён в стабилизатор хранилища.");
        this.lang("ru_ru").add("ritual.occultism.craft_stabilizer_tier4.interrupted", "Заточение Марида прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_stable_wormhole.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_stable_wormhole.started", "Заточение Фолиота в каркас червоточины началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_stable_wormhole.finished", "Фолиот успешно заточён в каркас червоточины.");
        this.lang("ru_ru").add("ritual.occultism.craft_stable_wormhole.interrupted", "Заточение Фолиота прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_remote.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_remote.started", "Заточение Джинна в удалённое хранилище началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_remote.finished", "Джинн успешно заточён в удалённое хранилище.");
        this.lang("ru_ru").add("ritual.occultism.craft_storage_remote.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_lenses.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_lenses.started", "Заточение Фолиота в линзы началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_lenses.finished", "Фолиот успешно заточён в линзы.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_lenses.interrupted", "Заточение Фолиота прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_pickaxe.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_pickaxe.started", "Заточение Джинна в кирку началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_pickaxe.finished", "Джинн успешно заточён в кирке.");
        this.lang("ru_ru").add("ritual.occultism.craft_infused_pickaxe.interrupted", "Заточение Джинна прервано.");

        this.lang("ru_ru").add("ritual.occultism.craft_miner_foliot_unspecialized.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_foliot_unspecialized.started", "Вызов Фолиота в магическую лампу начался.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_foliot_unspecialized.finished", "Фолиот успешно вызван в магическую лампу.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_foliot_unspecialized.interrupted", "Вызов Фолиота прерван.");

        this.lang("ru_ru").add("ritual.occultism.craft_miner_djinni_ores.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_djinni_ores.started", "Вызов Джинна в магическую лампу начался.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_djinni_ores.finished", "Джинн успешно вызван в магическую лампу.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_djinni_ores.interrupted", "Вызов Джинна прерван.");

        this.lang("ru_ru").add("ritual.occultism.craft_miner_afrit_deeps.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_afrit_deeps.started", "Вызов Африта в магическую лампу начался.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_afrit_deeps.finished", "Африт успешно вызван в магическую лампу.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_afrit_deeps.interrupted", "Вызов Африта прерван.");

        this.lang("ru_ru").add("ritual.occultism.craft_miner_marid_master.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_marid_master.started", "Вызов Марида в Магическую лампу начался.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_marid_master.finished", "Марид успешно вызван в Магическую лампу.");
        this.lang("ru_ru").add("ritual.occultism.craft_miner_marid_master.interrupted", "Вызов Марида прерван.");
		
		this.lang("ru_ru").add("ritual.occultism.misc_miner_ancient_eldritch.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.misc_miner_ancient_eldritch.started", "Вызов нечто в магическую лампу начался.");
        this.lang("ru_ru").add("ritual.occultism.misc_miner_ancient_eldritch.finished", "Вызов нечто в магическую лампу успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.misc_miner_ancient_eldritch.interrupted", "Вызов нечто прерван.");

        this.lang("ru_ru").add("ritual.occultism.craft_satchel.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_satchel.started", "Заточение Фолиота в наплечную сумку началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_satchel.finished", "Фолиот успешно заточён в наплечную сумку.");
        this.lang("ru_ru").add("ritual.occultism.craft_satchel.interrupted", "Заточение Фолиота прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_soul_gem.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_soul_gem.started", "Заточение Джинна в камень душ началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_soul_gem.finished", "Джинн успешно заточён в камень душ.");
        this.lang("ru_ru").add("ritual.occultism.craft_soul_gem.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_familiar_ring.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_familiar_ring.started", "Заточение Джинна в кольцо для фамильяра началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_familiar_ring.finished", "Джинн успешно заточён в кольцо для фамильяра.");
        this.lang("ru_ru").add("ritual.occultism.craft_familiar_ring.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.misc_wild_trim.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.misc_wild_trim.started", "Дикие духи начали создавать Кузнечный шаблон.");
        this.lang("ru_ru").add("ritual.occultism.misc_wild_trim.finished", "Создание кузнечного шаблона прошло успешно.");
        this.lang("ru_ru").add("ritual.occultism.misc_wild_trim.interrupted", "Заточение Джинна прервано.");
        this.lang("ru_ru").add("ritual.occultism.possess_endermite.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_endermite.started", "Вызов Одержимого эндермита начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_endermite.finished", "Одержимый эндермит успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_endermite.interrupted", "Вызов Одержимого эндермита прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_skeleton.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_skeleton.started", "Вызов Одержимого скелета начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_skeleton.finished", "Одержимый скелет успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_skeleton.interrupted", "Вызов Одержимого скелета прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_enderman.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_enderman.started", "Вызов Одержимого эндермена начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_enderman.finished", "Одержимый эндермен успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_enderman.interrupted", "Вызов Одержимого эндермена прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_ghast.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_ghast.started", "Вызов Одержимого гаста начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_ghast.finished", "Одержимый гаст успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_ghast.interrupted", "Вызов Одержимого гаста прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_phantom.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_phantom.started", "Вызов Одержимого фантома начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_phantom.finished", "Одержимый фантом успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_phantom.interrupted", "Вызов Одержимого фантома прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_weak_shulker.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_weak_shulker.started", "Вызов Одержимого слабого шалкера начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_weak_shulker.finished", "Одержимый слабый шалкер успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_weak_shulker.interrupted", "Вызов Одержимого слабого шалкера прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_shulker.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_shulker.started", "Вызов Одержимого шалкера начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_shulker.finished", "Одержимый шалкер успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_shulker.interrupted", "Вызов Одержимого шалкера прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_elder_guardian.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_elder_guardian.started", "Вызов Одержимого древнего стража начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_elder_guardian.finished", "Одержимый древний страж успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_elder_guardian.interrupted", "Вызов Одержимого древнего стража прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_warden.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_warden.started", "Вызов Одержимого хранителя начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_warden.finished", "Одержимый хранитель успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_warden.interrupted", "Вызов Одержимого хранителя прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_hoglin.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_hoglin.started", "Вызов Одержимого хоглина начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_hoglin.finished", "Одержимый хоглин успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_hoglin.interrupted", "Вызов Одержимого хоглина прерван.");
		this.lang("ru_ru").add("ritual.occultism.possess_witch.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_witch.started", "Вызов Одержимой ведьмы начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_witch.finished", "Одержимая ведьма успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.possess_witch.interrupted", "Вызов Одержимой ведьмы прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_zombie_piglin.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_zombie_piglin.started", "Вызов Одержимого зомбифицированного пиглина начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_zombie_piglin.finished", "Одержимый зомбифицированный пиглин успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_zombie_piglin.interrupted", "Вызов Одержимого зомбифицированного пиглина прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_bee.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_bee.started", "Вызов Одержимой пчелы начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_bee.finished", "Одержимая пчела успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.possess_bee.interrupted", "Вызов Одержимой пчелы прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_goat.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_goat.started", "Вызов Козла милосердия начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_goat.finished", "Козёл милосердия успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_goat.interrupted", "Вызов Козла милосердия прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_otherworld_bird.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_otherworld_bird.started", "Вызов Дрикрыла-фамильяр начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_otherworld_bird.finished", "Дрикрыл-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_otherworld_bird.interrupted", "Вызов Дрикрыра-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_cthulhu.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_cthulhu.started", "Вызов Ктулху-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_cthulhu.finished", "Ктулху-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_cthulhu.interrupted", "Вызов Ктулху-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_devil.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_devil.started", "Вызов Дьявола-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_devil.finished", "Дьявол-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_devil.interrupted", "Вызов Дьявола-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_dragon.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_dragon.started", "Вызов Дракона-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_dragon.finished", "Дракон-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_dragon.interrupted", "Вызов Дракона-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_blacksmith.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_blacksmith.started", "Вызов Кузнеца-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_blacksmith.finished", "Кузнец-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_blacksmith.interrupted", "Вызов Кузнеца-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_guardian.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_guardian.started", "Вызов Стража-фамильяр начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_guardian.finished", "Страж-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_guardian.interrupted", "Вызов Стража-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_otherworld_bird.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_otherworld_bird.started", "Вызов Дикого дрикрыла начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_otherworld_bird.finished", "Дикий дрикрыл успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_otherworld_bird.interrupted", "Вызов Дикого дрикрыла прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_parrot.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_parrot.started", "Вызов Дикого попугая начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_parrot.finished", "Дикий попугай успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.possess_unbound_parrot.interrupted", "Вызов Дикого попугая прерван.");

        this.add("ritual.occultism.possess_random_animal_common.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_common.started", "Вызов обычного случайного животного начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_common.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_common.interrupted", "Вызов случайного обычного животного прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_water.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_water.started", "Вызов случайного водяного животного начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_water.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_water.interrupted", "Вызов случайного водяного животного прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_small.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_small.started", "Вызов малого случайного животного начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_small.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_small.interrupted", "Вызов случайного малого животного прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_special.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_special.started", "Вызов случайного специального животного начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_special.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_special.interrupted", "Вызов случайного специального животного прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_rideable.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_rideable.started", "Вызов ездового случайного животного начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_rideable.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_random_animal_rideable.interrupted", "Вызов случайного ездового животного прерван.");
        this.lang("ru_ru").add("ritual.occultism.possess_villager.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.possess_villager.started", "Вызов крестьянина начался.");
        this.lang("ru_ru").add("ritual.occultism.possess_villager.finished", "Успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.possess_villager.interrupted", "Вызов крестьянина прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_parrot.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_parrot.started", "Вызов Попугая-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_parrot.finished", "Попугай-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_parrot.interrupted", "Вызов Попугая-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.resurrect_allay.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.resurrect_allay.started", "Очистка с Вредины до Тихони началась.");
        this.lang("ru_ru").add("ritual.occultism.resurrect_allay.finished", "Очистка с Вредины до Тихони прошла успешно.");
        this.lang("ru_ru").add("ritual.occultism.resurrect_allay.interrupted", "Очистка с Вредины до Тихони прервана.");
        this.lang("ru_ru").add("ritual.occultism.familiar_greedy.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_greedy.started", "Вызов Алчного фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_greedy.finished", "Алчный фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_greedy.interrupted", "Вызов Алчного фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_bat.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_bat.started", "Вызов Летучей мыши-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_bat.finished", "Летучая мышь-фамильяр успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.familiar_bat.interrupted", "Вызов Летучей мыши-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_deer.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_deer.started", "Вызов Оленя-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_deer.finished", "Олень-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_deer.interrupted", "Вызов Оленя-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_headless.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_headless.started", "Вызов Безголового человека-крысы-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_headless.finished", "Безголовый человек-крыса-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_headless.interrupted", "Вызов Безголового человека-крысы-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_chimera.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_chimera.started", "Вызов Химеры-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_chimera.finished", "Химера-фамильяр успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.familiar_chimera.interrupted", "Вызов Химеры-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beholder.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beholder.started", "Вызов Созерцателя-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beholder.finished", "Созерцатель-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beholder.interrupted", "Вызов Созерцателя-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_fairy.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_fairy.started", "Вызов Феи-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_fairy.finished", "Фея-фамильяр успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.familiar_fairy.interrupted", "Вызов Феи-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_mummy.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_mummy.started", "Вызов Мумии-фамильяр начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_mummy.finished", "Мумия-фамильяр успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.familiar_mummy.interrupted", "Вызов Мумии-фамильяра прерван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beaver.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beaver.started", "Вызов Бобра-фамильяра начался.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beaver.finished", "Бобёр-фамильяр успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.familiar_beaver.interrupted", "Вызов Бобра-фамильяра прерван.");

        this.lang("ru_ru").add("ritual.occultism.summon_demonic_wife.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_wife.started", "Вызов демонической жены начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_wife.finished", "Демоническая жена успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_wife.interrupted", "Вызов демонической жены прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_husband.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_husband.started", "Вызов демонического мужа начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_husband.finished", "Демонический муж успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.summon_demonic_husband.interrupted", "Вызов демонического мужа прерван.");

        this.lang("ru_ru").add("ritual.occultism.wild_husk.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_husk.started", "Вызов Орды диких кадавров начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_husk.finished", "Орда диких кадавров успешна вызвана.");
        this.lang("ru_ru").add("ritual.occultism.wild_husk.interrupted", "Вызов Орды диких кадавров прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_drowned.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_drowned.started", "Вызов Орды диких утопленников начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_drowned.finished", "Орда диких утопленников успешна вызвана.");
        this.lang("ru_ru").add("ritual.occultism.wild_drowned.interrupted", "Вызов Орды диких утопленников прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_creeper.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_creeper.started", "Вызов Орды диких криперов начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_creeper.finished", "Орда диких криперов успешна вызвана.");
        this.lang("ru_ru").add("ritual.occultism.wild_creeper.interrupted", "Вызов Орды диких криперов прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_silverfish.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_silverfish.started", "Вызов Орды диких чешуйниц начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_silverfish.finished", "Орда диких чешуйниц успешно вызвана.");
        this.lang("ru_ru").add("ritual.occultism.wild_silverfish.interrupted", "Вызов Орды диких чешуйниц прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_weak_breeze.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_weak_breeze.started", "Вызов Одержимого слабого вихря начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_weak_breeze.finished", "Одержимый слабый вихрь успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.wild_weak_breeze.interrupted", "Вызов Одержимого слабого вихря прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_breeze.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_breeze.started", "Вызов Одержимого вихря начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_breeze.finished", "Одержимый вихрь успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.wild_breeze.interrupted", "Вызов Одержимого вихря прерван.");
        this.lang("ru_ru").add("ritual.occultism.wild_strong_breeze.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.wild_strong_breeze.started", "Вызов Одержимого сильного вихря начался.");
        this.lang("ru_ru").add("ritual.occultism.wild_strong_breeze.finished", "Одержимый сильный вихрь успешно вызван.");
        this.lang("ru_ru").add("ritual.occultism.wild_strong_breeze.interrupted", "Вызов Одержимого сильного вихря прерван.");
        this.lang("ru_ru").add("ritual.occultism.summon_horde_illager.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.summon_horde_illager.started", "Вызов Нашествия диких обитателей начался.");
        this.lang("ru_ru").add("ritual.occultism.summon_horde_illager.finished", "Нашествие диких обитателей успешно вызвано.");
        this.lang("ru_ru").add("ritual.occultism.summon_horde_illager.interrupted", "Вызов Нашествия диких обитателей прерван.");

        this.add("ritual.occultism.wild_random_animal_common.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_random_animal_common.started", "Начался вызов группы случайных обычных животных.");
        this.add("ritual.occultism.wild_random_animal_common.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_random_animal_common.interrupted", "Вызов группы случайных обычных животных прерван.");
        this.add("ritual.occultism.wild_random_animal_water.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_random_animal_water.started", "Вызов группы случайных водяных животных начался.");
        this.add("ritual.occultism.wild_random_animal_water.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_random_animal_water.interrupted", "Вызов группы случайных водяных животных прерван.");
        this.add("ritual.occultism.wild_random_animal_small.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_random_animal_small.started", "Вызов группы случайных малых животных начался.");
        this.add("ritual.occultism.wild_random_animal_small.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_random_animal_small.interrupted", "Вызов группы случайных малых животных прерван.");
        this.add("ritual.occultism.wild_random_animal_special.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_random_animal_special.started", "Вызов группы случайных специальных животных начался.");
        this.add("ritual.occultism.wild_random_animal_special.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_random_animal_special.interrupted", "Вызов группы случайных специальных животных прерван.");
        this.add("ritual.occultism.wild_random_animal_rideable.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_random_animal_rideable.started", "Вызов группы случайных ездовых животных начался.");
        this.add("ritual.occultism.wild_random_animal_rideable.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_random_animal_rideable.interrupted", "Вызов группы случайных ездовых животных прерван.");
        this.add("ritual.occultism.wild_villager.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.add("ritual.occultism.wild_villager.started", "Вызов группы крестьян начался.");
        this.add("ritual.occultism.wild_villager.finished", "Успешно вызвана.");
        this.add("ritual.occultism.wild_villager.interrupted", "Вызов группы крестьян прерван.");

        this.lang("ru_ru").add("ritual.occultism.craft_nature_paste.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_nature_paste.started", "Наполнение природной пасты началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_nature_paste.finished", "Наполнение природной пасты прошло успешно.");
        this.lang("ru_ru").add("ritual.occultism.craft_nature_paste.interrupted", "Создание природной пасты прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_gray_paste.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_gray_paste.started", "Наполнение серой пасты началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_gray_paste.finished", "Наполние серой пасты прошло успешно.");
        this.lang("ru_ru").add("ritual.occultism.craft_gray_paste.interrupted", "Создание серой пасты прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_research_fragment_dust.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_research_fragment_dust.started", "Наполнение пыли фрагмента исследования началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_research_fragment_dust.finished", "Наполнение пыли фрагмента исследования прошло успешно");
        this.lang("ru_ru").add("ritual.occultism.craft_research_fragment_dust.interrupted", "Создание пыли фрагмента исследования прервано.");
        this.lang("ru_ru").add("ritual.occultism.craft_witherite_dust.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.craft_witherite_dust.started", "Наполнение Визерита началось.");
        this.lang("ru_ru").add("ritual.occultism.craft_witherite_dust.finished", "Наполнение визерита прошло успешно.");
        this.lang("ru_ru").add("ritual.occultism.craft_witherite_dust.interrupted", "Создание Визерита прервано.");
	    this.lang("ru_ru").add("ritual.occultism.repair_chalks.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.repair_chalks.started", "Починка мела началась.");
        this.lang("ru_ru").add("ritual.occultism.repair_chalks.finished", "Мел успешно починен.");
        this.lang("ru_ru").add("ritual.occultism.repair_chalks.interrupted", "Починка мела прервана.");
        this.lang("ru_ru").add("ritual.occultism.repair_tools.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.repair_tools.started", "Починка инструмента началась.");
        this.lang("ru_ru").add("ritual.occultism.repair_tools.finished", "Инструмент успешно починен.");
        this.lang("ru_ru").add("ritual.occultism.repair_tools.interrupted", "Починка инструмента прервана.");
        this.lang("ru_ru").add("ritual.occultism.repair_armors.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.repair_armors.started", "Починка брони началась.");
        this.lang("ru_ru").add("ritual.occultism.repair_armors.finished", "Броня успешно починена.");
        this.lang("ru_ru").add("ritual.occultism.repair_armors.interrupted", "Починка брони прервана.");
        this.lang("ru_ru").add("ritual.occultism.repair_miners.conditions", "Для этого ритуала удовлетворены не все требования.");
        this.lang("ru_ru").add("ritual.occultism.repair_miners.started", "Восстановление рудокопа началось.");
        this.lang("ru_ru").add("ritual.occultism.repair_miners.finished", "Рудокоп успешно восстановлен.");
        this.lang("ru_ru").add("ritual.occultism.repair_miners.interrupted", "Восстановление рудокопа прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER, "started", "Вызов Дробильщика-Фолиота начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER, "finished", "Дробильщик-Фолиот успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER, "interrupted", "Вызов Дробильщика-Фолиота прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER, "started", "Вызов Джинна-Дробильщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER, "finished", "Джинн-Дробильщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER, "interrupted", "Вызов Джинна-Дробильщика прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER, "started", "Вызов Африта-Дробильщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER, "finished", "Африт-Дробильщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER, "interrupted", "Вызов Африта-Дробильщика прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER, "started", "Вызов Марида-Дробильщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER, "finished", "Марид-Дробильщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER, "interrupted", "Вызов Марида-Дробильщика прерван.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER, "started", "Вызов Фолиота-Литейщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER, "finished", "Фолиот-Литейщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER, "interrupted", "Вызов Фолиота-Литейщика прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER, "started", "Вызов Джинна-Литейщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER, "finished", "Джинн-Литейщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER, "interrupted", "Вызов Литейщика-Джинна прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER, "started", "Вызов Африта-Литейщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER, "finished", "Африт-Литейщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER, "interrupted", "Вызов Литейщика-Африта прерван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER, "conditions", "Для этого ритуала удовлетворены не все требования.");

		this.addRitualMessage(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM, "started", "Одержимость Марида в Айзниевом големе началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM, "finished", "Марид успешно заточён в Айзниевом големе.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM, "interrupted", "Одержимость Маридом прервана.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER, "started", "Вызов Марида-Литейщика начался.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER, "finished", "Марид-Литейщик успешно вызван.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER, "interrupted", "Вызов Марида-Литейщика прерван.");

        this.addRitualMessage(OccultismRituals.RESURRECT_FAMILIAR, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismRituals.RESURRECT_FAMILIAR, "started", "Воскресение фамильяра началось.");
        this.addRitualMessage(OccultismRituals.RESURRECT_FAMILIAR, "finished", "Фамильяр воскрешён успешно.");
        this.addRitualMessage(OccultismRituals.RESURRECT_FAMILIAR, "interrupted", "Воскресение прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1, "started", "Заточение Джинна в наплечную сумку началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1, "finished", "Джинн успешно заточён в наплечную сумку.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1, "interrupted", "Заточение Джинна прервано.");

		this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2, "conditions", "Для этого ритуала удовлетворены не все требования.");

		this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL, "started", "Заточение Африта в айзнивую жертвенную миску началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL, "finished", "Африт успешно заточён в айзниевую жертвенную миску.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL, "interrupted", "Заточение Африта прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL, "started", "Заточение Марида в Айзниевую наковальню началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL, "finished", "Марид успешно заточён в Айзниевую наковальню.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL, "interrupted", "Заточение Марида прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2, "started", "Заточение Африта в Наплечную сумку началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2, "finished", "Африт успешно заточён в Наплечную сумку.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2, "interrupted", "Заточение Африта прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST, "started", "Создание цветущего аметиста началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST, "finished", "Цветущий аметист успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST, "interrupted", "Создание цветущего аметиста прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE, "conditions", "Для этого ритуала удовлетворены не все требования.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE, "started", "Создание сверхъестественного потира началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE, "finished", "Сверхъестественный потир успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE, "interrupted", "Создание сверхъестественного потира прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE, "started", "Создание актуатора стабилизатора пространственного хранилища началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE, "finished", "Актуатор стабилизатора пространственного хранилища успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE, "interrupted", "Создание актуатора стабилизатора пространственного хранилища прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW, "started", "Создание радужного мела началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW, "finished", "Радужный мел успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW, "interrupted", "Создание радужного мела прервана.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID, "started", "Создание пустотного мела началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID, "finished", "Пустотный мел успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID, "interrupted", "Создание пустотного мела прервана.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM, "started", "Создание камня Троицы началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM, "finished", "Камень Троицы успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM, "interrupted", "Создание камня Троицы прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE, "started", "Создание укреплённого глубинного сланца началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE, "finished", "Укреплённый глубинный сланец успешно создан.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE, "interrupted", "Создание укреплённого глубинного сланца прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST, "started", "Создание пчелиного гнезда началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST, "finished", "Пчелиное гнездо создано успешно.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST, "interrupted", "Создание пчелиного гнезда прервано.");

        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BELL, "conditions", "Для этого ритуала удовлетворены не все требования.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BELL, "started", "Создание колокола началось.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BELL, "finished", "Колокол создан успешно.");
        this.addRitualMessage(OccultismItems.RITUAL_DUMMY_FORGE_BELL, "interrupted", "Создание колокола прервано.");
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
        this.lang("ru_ru").add(helper.categoryName(), "Ритуалы");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуалы");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы позволяют вызывать духов в нашу параллельную реальность или заточать их в предметы или живые существа. Каждый ритуал состоит из: [#](%1$s)Пентакль[#](), [#](%1$s)ингредиенты для ритуала[#](), снабжаемые через жертвенные миски, [#](%1$s)запускающий предмет[#](), а в некоторых случаях — [#](%1$s)Жертвоприношение[#]() живых существ. Пурпурные частицы покажут, что ритуал удался и выполняется.
                        """.formatted(COLOR_PURPLE));

        helper.page("steps");
        this.lang("ru_ru").add(helper.pageTitle(), "Выполнение ритуала");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы всегда выполняются по неизменным этапам:
                        - Начертить пентакль;
                        - Поставить золотую миску;
                        - Расположить жертвенные миски;
                        - Положить ингредиенты в миски;
                        - Нажать [#](%1$s)ПКМ[#]() по золотой миске с помощью активационного предмета.
                        - *Необязательно: совершить жертвоприношение в центре пентакля.*
                        """.formatted(COLOR_PURPLE));

        helper.page("additional_requirements");
        this.lang("ru_ru").add(helper.pageTitle(), "Дополнительные требования");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Если ритуал показывает серые частицы над золотой жертвенной миской, нужно удовлетворить дополнительные требования в порядке, предусмотренном на странице ритуала. После удовлетворения всех требований: ритуал покажет пурпурные частицы и начнёт тратить предметы в жертвенных мисках.
                        """);

        helper.entry("item_use");
        this.lang("ru_ru").add(helper.entryName(), "Использование предмета");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Использование предмета");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Для выполнения некоторых ритуалов требуется использовать определённые предметы. Чтобы провести ритуал, используйте предмет, отмеченный на странице ритуала в радиусе 16 блоков от [](item://occultism:golden_sacrificial_bowl) для проведения риутала.
                        \\
                        \\
                        **Примечание**: начните ритуал перед использованием предмета. Серые частицы указывают, что ритуал готов использовать предмет.
                        """);

        helper.entry("sacrifice");
        this.lang("ru_ru").add(helper.entryName(), "Жертвы");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Жертвы");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Некоторые ритуалы требуют жертвоприношение живых существ, чтобы обеспечить необходимую энергию для вызова духа. Жертвы отмечены на странице ритуала в подразделе "Жертвоприношение". Чтобы выполнить жертвоприношение: убейте животное в радиусе 8 блоков от золотой жертвенной миски; жертвоприношение считается только убийством, совершённым игроком!
                         """);

        helper.entry("summoning_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы вызова");

        helper.entry("possession_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы одержимости");

        helper.entry("crafting_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы заточения");

        helper.entry("familiar_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы для фамильяров");
    }

    private void addSummoningRitualsCategory(BookContextHelper helper) {
        helper.category("summoning_rituals");
        this.lang("ru_ru").add(helper.categoryName(), "Ритуалы вызова");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы вызова");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуалы вызова");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы вызова заставляют духов входить в этот мир в своём Избранном облике, что приводит к небольшим ограничениям на их силе. Вызванные духи классифицируются от Духов-Торговцев, которые торгуют и преобразуют предметы, до рабов-помощников для физического труда.
                         """);

        helper.entry("return_to_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Вернуться в категорию ритуалов");

        helper.entry("summon_crusher_t1");
        //Перемещён в OccultismBookProvider#makeSummonCrusherT1Entry

        helper.entry("summon_crusher_t2");
        this.lang("ru_ru").add(helper.entryName(), "Вызов Джинна-Дробильщика");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Джинн-Дробильщик");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Джинн-Дробильщик быстрее, эффективнее и искуснее Фолиота-Дробильщика,
                        что позволяет ему дробить лёд, не растапливая.
                        \\
                        Он дробит **одну** руду на **три** аналогичные пыли.
                         """);

        helper.page("ritual");
        //текст отсутствует

        helper.entry("summon_crusher_t3");
        this.lang("ru_ru").add(helper.entryName(), "Вызов Африта-Дробильщика");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Африт-Дробильщик");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Африт-Дробильщик быстрее и эффективнее Джинна-Дробильщика.
                        \\
                        Он дробит **одну** руду на **четыре** аналогичных пыли.
                          """);

        helper.page("ritual");
        //текст отсутствует

        helper.entry("summon_crusher_t4");
        this.lang("ru_ru").add(helper.entryName(), "Вызов Марида-Дробильщика");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Марид-Дробильщик");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Марид-Дробильщик быстрее, эффективнее и искуснее Африта-Дробильщика,
                        что позволяет ему дробить Осколок Эха с сохранением его свойств.
                        \\
                        Он дробит **одну** руду на **шесть** аналогичных пылей.
                          """);

        helper.page("ritual");
        //текст отсутствует


        helper.entry("summon_lumberjack");
        //Moved to OccultismBookProvider#makeSummonLumberjackEntry

        helper.entry("summon_transport_items");
        //Moved to OccultismBookProvider#makeSummonTransportItemsEntry


        helper.entry("summon_cleaner");
        //Moved to OccultismBookProvider#makeSummonCleanerEntry

        helper.entry("summon_manage_machine");
        this.lang("ru_ru").add(helper.entryName(), "Вызов Джинна-Станочника");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Джинн-Станочник");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Станочник перемещает предметы, указанные в графическом интерфейсе актуатора пространственного хранилища, в свою выбранную машину и возвращает результаты создания в систему хранения. Он также может использоваться для автоматического опустошения сундука в Актуатор хранилища.
                        \\
                        По сути, — это создание по заказу!
                          """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("tutorial");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Чтобы использовать станочника, используйте книгу вызова для связи Актуатора хранилища, машины и, по желанию, отдельного места извлечения: лицевой стороны, откуда будут извлекаться предметы (по нажатию!). Для машины Вы можете дополнительно задать пользовательское название и лицевые стороны ввода/извлечения.
                          """);

        helper.page("tutorial2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Обратите внимание: установка новой машины либо её настройка с помощью книги вызова сбросит настройки извлечения.
                        \\
                        \\
                        Для лёгкого старта убедитесь, что посмотрели короткую [видеоинструкцию](https://gyazo.com/237227ba3775e143463b31bdb1b06f50)!
                          """);

        helper.page("book_of_calling");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Если потеряете Книгу вызова, сможете создать новую.
                        Нажмите [#](%1$s)Shift + ПКМ[#]() по духу с помощью созданной книги, чтобы определить её.
                        """.formatted(COLOR_PURPLE));

        helper.entry("trade_spirits");
        this.lang("ru_ru").add(helper.entryName(), "Духи-торговцы");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Духи-торговцы");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Духи-торговцы подбирают необходимые предметы и кидают результаты обмена на землю. Дух активно меняет предметы лишь в случаях, когда вокруг него появляются пурпурные частицы.
                        \\
                        \\
                        **Если Вы не видите частиц**, убедитесь, что дали надлежащий предмет и количество.
                           """);

        helper.page("intro2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Большинство духов-торговцев испытывают чрезмерный распад сущности и немедленно возвращаются в [#](%1$s)Иное Место[#]().
                           """.formatted(COLOR_PURPLE));

        helper.entry("summon_otherworld_sapling_trader");
        this.lang("ru_ru").add(helper.entryName(), "Вызов торговца потусторонними саженцами");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Торговец потусторонними саженцами");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Потусторонние деревья, выращенные из Потусторонних саженцев, могут быть добыты только во время действия эффекта [#](%1$s)Третьего глаза[#](). Для упрощения жизни Торговец потусторонними саженцами будет обменивать столь естественные саженцы на стабильную разновидность, добываемую кем угодно, а при добыче выдавать такие же стабильные саженцы.
                           """.formatted(COLOR_PURPLE));

        helper.page("trade");
        //текст отсутствует

        helper.page("ritual");
        //текст отсутствует

        helper.entry("summon_otherstone_trader");
        this.lang("ru_ru").add(helper.entryName(), "Вызов торговца потусторонним камнем");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Торговец потусторонним камнем");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Торговец потусторонним камнем (дух) позволяет получить больше [](item://occultism:otherstone) вместо того, чтобы использовать [](item://occultism:spirit_fire). Получается, что это вдвойне выгодно, если нужно использовать Потусторонний камень в качестве строительного материала.
                           """);

        helper.page("trade");
        //текст отсутствует

        helper.page("ritual");
        //текст отсутствует

        helper.entry("invoke_unbound_parrot");
        this.lang("ru_ru").add(helper.entryName(), "Вызов несвязанного попугая");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: Приручаемого попугая.
                          """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        При проведении этого ритуала [#](%1$s)Фолиот[#]() вызывается **в качестве фамильяра**.
                        \\
                        \\
                        Убийство [#](%1$s)Курицы[#]() и подношение красителей предназначается для того, чтобы склонить Фолиота принять облик попугая. Хотя [#](%1$s)Фолиот[#]() не находится среди умнейших духов — в ряде случаях он дурно понимает указания...
                          """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        *Следовательно, если появится [#](%1$s)Курица[#](), это не ошибка, просто не повезло!*
                           """.formatted(COLOR_PURPLE));

        helper.entry("possess_unbound_otherworld_bird");
        this.lang("ru_ru").add(helper.entryName(), "Овладение несвязанным дрикрылом");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: Приручаемого дрикрыла.
                          """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Дополнительные сведения см. в [Дрикрыл-фамильяр](entry://familiar_rituals/familiar_otherworld_bird).
                          """);

        helper.entry("weather_magic");
        this.lang("ru_ru").add(helper.entryName(), "Магия погоды");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Магия погоды");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Магия погоды весьма полезна для фермеров и других людей, в зависимости от конкретной погоды. Вызывайте духов ради изменения погоды. Для разных видов изменения погоды требуются определённые духи.
                        \\
                        \\
                        Духи погоды изменяют лишь только погоду, а затем исчезают.
                           """);

        helper.page("ritual_clear");
        //текст отсутствует

        helper.page("ritual_rain");
        //текст отсутствует

        helper.page("ritual_thunder");
        //текст отсутствует

        helper.entry("time_magic");
        this.lang("ru_ru").add(helper.entryName(), "Магия времени");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Магия времени");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Магия времени ограничена возможностями: она не может перемещать заклинателя во времени; однако скорее позволяет изменять время дня. Это особенно полезно для ритуалов или других задач, требующих сугубо дня и ночи.
                        \\
                        \\
                        Духи времени изменяют только время, а затем исчезают.
                           """);

        helper.page("ritual_day");
        //текст отсутствует

        helper.page("ritual_night");
        //текст отсутствует

        helper.entry("afrit_essence");
        this.add(helper.entryName(), "Сущность Африта");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Сущность Африта");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [](item://occultism:afrit_essence) широко используется для создания красного мела, необходимого для безопасного вызова более могущественных духов. Чтобы получить сущность [#](%1$s)Африта[#]() в этой реальности, нужно вызвать незаточённого Африта и убить. Имейте ввиду, что это непростая затея: незаточённый дух представляет большую угрозу для всех поблизости.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("marid_essence");
        this.add(helper.entryName(), "Сущность Марида");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Сущность Марида");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [](item://occultism:marid_essence) широко используется для создания синего мела, необходимого для безопасного контроля самых могущественных духов. Чтобы получить сущность [#](%1$s)Марида[#]() в этой реальности, нужно вызвать незаточённого Марида и убить. Имейте ввиду, что это непростая затея: незаточённый дух представляет большую угрозу для всех поблизости.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует
    }

    private void addPossessionRitualsCategory(BookContextHelper helper) {
        helper.category("possession_rituals");
        this.lang("ru_ru").add(helper.categoryName(), "Ритуалы одержимости");

        helper.entry("return_to_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Вернуться в категорию ритуалов");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы одержимости");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуалы одержимости");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы одержимости заточают духов в живых существ, что в значительной степени дают вызывателю контроль над одержимым существом.
                        \\
                        \\
                        По сути, эти ритуалы используются для получения редких предметов, избегая опасных мест.
                           """);

        helper.entry("possess_enderman");
        this.lang("ru_ru").add(helper.entryName(), "Одержимый эндермен");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Добыча**: 1-3х [](item://minecraft:ender_pearl)
                                """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        При проведении этого ритуала (используя жизненную энергию [#](%1$s)Свиньи[#]()) появляется [#](%1$s)Эндермен[#]()), и почти сразу же завладевается вызванным [#](%1$s)Джинном[#](). При убийстве с [#](%1$s)Одержимого эндермена[#]() всегда выпадает минимум один [](item://minecraft:ender_pearl)
                                """.formatted(COLOR_PURPLE));

        helper.entry("wither_skull");
        this.add(helper.entryName(), "Дикая Охота");

        helper.page("intro");
        this.add(helper.pageTitle(), "Череп визер-скелета");
        this.add(helper.pageText(),
                """
                        Помимо опасного путешествия в Незер, существует ещё другой способ получить эти черепа. Легендарная [#](%1$s)Дикая Охота[#]() состоит из [#](%1$s)Могущественных духов[#](), принявших облик Визер-скелетов. Хотя вызов Дикой Охоты невероятно опасен — наибыстрейший способ получения черепов визер-скелетов.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("possess_endermite");
        this.lang("ru_ru").add(helper.entryName(), "Одержимый эндермит");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Добыча**: 1-2х [](item://minecraft:end_stone)
                                """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        При проведении этого ритуала появляется [#](%1$s)Эндермит[#]() при обмане. Камни и земля символизируют окружающий мир, затем бросается яйцо для имитации использования Эндер-жемчуга. При появлении эндермита, вызванный [#](%1$s)Фолиот[#]() сразу же завладевает им, посещает [#](%1$s)Энд[#]() и возвращается обратно. При убийстве с [#](%1$s)Одержимого эндермита[#]() всегда выпадает минимум один [](item://minecraft:end_stone).
                                """.formatted(COLOR_PURPLE));

        helper.entry("possess_ghast");
        //moved to OccultismBookProvider#makePossessGhastEntry

        helper.entry("possess_skeleton");
        this.lang("ru_ru").add(helper.entryName(), "Одержимый скелет");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Добыча**: 1х [](item://minecraft:skeleton_skull)
                                """);

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        При проведении этого ритуала (используя жизненную энергию [#](%1$s)курицы[#]()) появляется [#](%1$s)Скелет[#](), и сразу же завладевается вызванным [#](%1$s)Фолиотом[#](). [#](%1$s)Одержимый скелет[#]() будет устойчивым к дневному свету, но при убийстве всегда выпадает минимум один [](item://minecraft:skeleton_skull).
                                """.formatted(COLOR_PURPLE));
    }

    private void addCraftingRitualsCategory(BookContextHelper helper) {
        helper.category("crafting_rituals");
        this.lang("ru_ru").add(helper.categoryName(), "Ритуалы связывания"); //done via the category provider for the rituals category

        helper.entry("return_to_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Вернуться в категорию ритуалов");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы заточения");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуалы заточения");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы заточения вселяют духов в предметы, где их силы используются для конкретной цели. Созданные предметы действуют в качестве простых чар, наделяющие силой или, наоборот, выполняют сложные задачи, чтобы помочь вызывателю.
                           """);

        helper.entry("craft_storage_system");
        this.lang("ru_ru").add(helper.entryName(), "Магическое хранилище");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Следующие записи показывают только ритуалы, связанные с системой Магического хранения. За подробной пошаговой инструкцией по созданию системы хранения, смотрите в категории [Магическое хранилище](category://storage).
                           """.formatted(COLOR_PURPLE));

        helper.entry("craft_dimensional_matrix");
        this.lang("ru_ru").add(helper.entryName(), "Пространственная матрица");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Пространственная матрица — это мостик в малое пространство для хранения предметов. [#](%1$s)Джинн[#](), заключённый в матрице, поддерживает стабильность пространства, а другие духи в стабилизаторах хранилища, как правило, помогают увеличить размер пространства.
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_infused_pickaxe");
        this.lang("ru_ru").add(helper.entryName(), "Наполненная кирка");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Обычно потусторонние руды могут быть добыты только с помощью инструментов из потустороннего металла. [](item://occultism:infused_pickaxe) служит временным решением классической дилеммы. Хрупкий кристалл, настроенный на духа, заселённый [#](%1$s)Джинном[#]() позволяет собирать руды, при этом слишком низкая прочность. [Айзниевая кирка](entry://getting_started/iesnium_pickaxe) относится к более прочному варианту..
                           """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_otherworld_goggles");
        this.lang("ru_ru").add(helper.entryName(), "Создание потусторонних очков");

        helper.page("goggles_spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [](item://occultism:otherworld_goggles) дают владельцу постоянный эффект [#](%1$s)Третий глаз[#](), что позволяет видеть даже те блоки, скрытые от тех, кто съел [Видение демона](entry://occultism:dictionary_of_spirits/getting_started/demons_dream).
                        \\
                        \\
                        Это изящно решает общераспространённую проблему вызывателей, находящихся под воздействием наркотического помутнения, что служит причиной всяческих расстройств.
                        """.formatted(COLOR_PURPLE));

        helper.page("goggles_more");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Однако очки сами по себе не дают возможность добывать материалы из Иного Места. Т.е. для разрушения блоков и получения Потусторонних разновидностей нужно не только носить очки, а также использовать [Наполненную кирку](entry://getting_started/infused_pickaxe), а ещё лучше [Айзниевую кирку](entry://getting_started/iesnium_pickaxe).
                        """.formatted(COLOR_PURPLE));

        helper.page("lenses_spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Потусторонние очки используют [#](%1$s)Фолиота[#](), заключённого в линзы. Фолиот передаёт владельцу способность видеть более высокие плоскости существования, тем самым позволяя видеть Потусторонние материалы.
                         """.formatted(COLOR_PURPLE));

        helper.page("lenses_more");
        this.lang("ru_ru").add(helper.pageTitle(), "Создание линз");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуал для вызова духа в линзы, необходимый для создания очков, как правило, считается одним из первых сложных ритуалов для начинающих вызывателей, указывая на то, что их навыки выходят за пределы базовых знаний, достигая совершенства.
                        """.formatted(COLOR_PURPLE));

        helper.page("lenses_recipe");
        //текст отсутствует

        helper.page("ritual");
        //текст отсутствует

        helper.page("goggles_recipe");
        //текст отсутствует

        helper.entry("craft_storage_controller_base");
        this.lang("ru_ru").add(helper.entryName(), "Основание актуатора хранилища");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Основание актуатора хранилища заточает [#](%1$s)Фолиота[#](), отвечающего за взаимодействие с предметами в матрице пространственного хранилища.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_stabilizer_tier1");
        this.lang("ru_ru").add(helper.entryName(), "Стабилизатор хранилища 1-го уровня");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Этот простой стабилизатор хранилища, заселённый [#](%1$s)Фолиотом[#](): поддерживает стойкость «Пространственной матрицы» во время стабильного состояния Пространственного хранилища, позволяя хранить много предметов.
                        \\
                        \\
                        По умолчанию каждый Стабилизатор 1-го уровня добавляет **64** типа предметов и 512.000 ед. вместимости.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_stabilizer_tier2");
        this.lang("ru_ru").add(helper.entryName(), "Стабилизатор хранилища 2-го уровня");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Этот улучшенный стабилизатор, заселённый [#](%1$s)Джинном[#](): поддерживает стойкость Пространственной матрицы во время стабильного состояния Пространственного хранилища, таким образом позволяя хранить ещё больше предметов.
                        \\
                        \\
                        По умолчанию каждый Стабилизатор 2-го уровня добавляет **128** типов предметов и 1.024.000 ед. вместимости.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_stabilizer_tier3");
        this.lang("ru_ru").add(helper.entryName(), "Стабилизатор хранилища 3-го уровня");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Этот продвинутый стабилизатор, заселённый [#](%1$s)Афритом[#](): поддерживает стойкость Пространственной матрицы во время стабильного состояния Пространственного хранилища, таким образом позволяя хранить ещё больше предметов.
                        \\
                        \\
                        По умолчанию каждый Стабилизатор 3-го уровня добавляет **256** типов предметов и 2.048.000 ед. вместимости.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_stabilizer_tier4");
        this.lang("ru_ru").add(helper.entryName(), "Стабилизатор хранилища 4-го уровня");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Этот весьма продвинутый стабилизатор, заселённый [#](%1$s)Маридом[#](): поддерживает стойкость Пространственной матрицы во время стабильного состояния пространственного хранилища, что таким образом позволяет хранить ещё больше предметов.
                        \\
                        \\
                        По умолчанию каждый Стабилизатор 4-го уровня добавляет **512** типа предметов и 4.098.000 ед. вместимости.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_stable_wormhole");
        this.lang("ru_ru").add(helper.entryName(), "Стабильная червоточина");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Стабильная червоточина позволяет получит доступ к пространственной матрице из удалённого места назначения.
                        \\
                        \\
                        Нажмите Shift + ПКМ по [](item://occultism:storage_controller) для её связки, затем поставьте червоточину в мир для использования в качестве удалённой точки доступа.
                         """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_storage_remote");
        this.lang("ru_ru").add(helper.entryName(), "Средство доступа удалённого хранилища");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [](item://occultism:storage_remote) может быть связано с [](item://occultism:storage_controller) при нажатии Shift + ПКМ. [#](%1$s)Джинн[#](), заточённый в средстве доступа, в дальнейшем сможет получить доступ к предметам из Актуатора даже из других измерений.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_foliot_miner");
        this.lang("ru_ru").add(helper.entryName(), "Фолиот-Рудокоп");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Фолиот-Рудокоп");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Духи-Рудокопы используют [](item://occultism:dimensional_mineshaft) для получения ресурсов из других измерений. Они вызываются и заключаются в магические лампы, из которых могут выходить только через шахты. Магическая лампа с ходом времени разрушается, и как только разрушится, дух освободится обратно в [#](%1$s)Иное Место[#]().
                        """.formatted(COLOR_PURPLE));

        helper.page("magic_lamp");
        this.lang("ru_ru").add(helper.pageTitle(), "Магическая лампа");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Для вызова и владения Духами-Рудокопами сперва нужно создать [Магическую лампу](entry://getting_started/magic_lamps). Ключевой ингредиент для этого [Айзний](entry://getting_started/iesnium).
                        """.formatted(COLOR_PURPLE));

        helper.page("magic_lamp_recipe");
        //текст отсутствует

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Рудокоп-[#](%1$s)Фолиот[#]() добывает блоки без особой цели и возвращает всё, что находит. Процесс добычи ресурсов довольно медленный, поэтому Фолиот потребляет небольшое количество энергии, которое со временем наносит вред лампе, где находится.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_djinni_miner");
        this.lang("ru_ru").add(helper.entryName(), "Джинн-Рудокоп");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Рудокоп-[#](%1$s)Джинн[#]() добывает только руду. Отсеивая другие блоки, способен быстрее и эффективнее добывать руды. Чем больше сила Джинна, тем сравнительно быстро вредит магической лампе.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_afrit_miner");
        this.lang("ru_ru").add(helper.entryName(), "Африт-Рудокоп");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Рудокоп-[#](%1$s)Африт[#]() добывает руду, как и Рудокопы-Джинны, а также глубинносланцевые руды. Этот рудокоп быстрее и эффективнее джинна, тем самым ещё медленнее вредя магической лампе.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_marid_miner");
        this.lang("ru_ru").add(helper.entryName(), "Марид-Рудокоп");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Рудокоп-[#](%1$s)Марид[#]() является самым могущественным духом-рудокопом. У него невероятная скорость добычи и лучшая сохранность магической лампы. В отличие от других духов-рудокопов, также способен добывать редчайшие руды, например, [](item://minecraft:ancient_debris) и [](item://occultism:iesnium_ore).
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_ancient_miner");
        this.add(helper.entryName(), "Древний рудокоп");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        Сжав «ДАМ» Вы получите сверхмогущественного рудокопа. Однако нечто начнёт за Вами наблюдать. [](item://occultism:mining_dim_core) крайне редко добывается Маридом.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_satchel");
        this.lang("ru_ru").add(helper.entryName(), "Необычайно большая сумка");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        На [#](%1$s)Фолиота[#](), заточённого в сумке, возлагается обязанность **едва** искажать реальность, позволяя хранить в сумке куча предметов, чем позволяют её физические размеры. Это делает её полезным спутником для путешественника.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_soul_gem");
        this.lang("ru_ru").add(helper.entryName(), "Камень душ");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Камень душ представляет собой алмаз, установленный в драгоценные металлы и затем наполненный [#](%1$s)Джинном[#](). Дух создаёт малое пространство, позволяя временно удерживать живых существ. Однако существ великой силы нельзя хранить.
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.lang("ru_ru").add(helper.pageTitle(), "Использование");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Нажатие [#](%1$s)ПКМ[#]() по существу с помощью Камня душ — поймать существо.
                        Повторное нажатие [#](%1$s)ПКМ[#]() — выпустить существо.
                        \\
                        \\
                        Босса невозможно поймать.
                               """.formatted(COLOR_PURPLE));


        helper.page("ritual");
        //текст отсутствует

        helper.entry("craft_familiar_ring");
        this.lang("ru_ru").add(helper.entryName(), "Кольцо для фамильяра");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Кольцо для фамильяра сделано из [](item://occultism:soul_gem), сдерживающего [#](%1$s)Джинна[#](), заточённого в кольцо. [#](%1$s)Джинн[#]() в кольце позволяет фамильяру, заключённому в камне душ накладывать эффекты на владельца.
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.lang("ru_ru").add(helper.pageTitle(), "Использование");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Чтобы использовать [](item://occultism:familiar_ring), поймайте вызванного и приручённого фамильяра, нажав [#](%1$s)ПКМ[#]() на него, а затем наденьте кольцо в качестве [#](%1$s)Аксессуара[#](), чтобы использовать эффекты, предоставляемые фамильяром.
                        \\
                        \\
                        Когда фамильяр освобождается из кольца, он признаёт (освободившего его человека) своим новым хозяином.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует
        helper.entry("craft_wild_trim");
        this.lang("ru_ru").add(helper.entryName(), "Отделка «Дебри»");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        В отличие от других ритуалов, создание [](item://minecraft:wild_armor_trim_smithing_template) представляет собой услугу, предлагаемую Дикими духами, не связывая духа к готовому предмету. Жертвуйте предметами, а Дикие духи используют свои силы, чтобы создать Вам предмет.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
		        //no text

        helper.entry("craft_budding_amethyst");
        this.add(helper.entryName(), "Создание цветущего аметиста");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        В оличие от других ритуалов, создание [](item://minecraft:budding_amethyst) представляет собой услугу, предлагаемую Дикими духами, не связывая духа к готовому предмету. Вы жертвуете предметами, а Дикие духи используют свои силы, чтобы создать Вам предмет.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("craft_reinforced_deepslate");
        this.add(helper.entryName(), "Создание укреплённого глубинного сланца");

        helper.page("spotlight");
        this.add(helper.pageText(),
                """
                        В отличие от других ритуалов, создание [](item://minecraft:reinforced_deepslate) представляет собой услугу, предлагаемую Дикими духами, не связывая духа к готовому предмету. Жертвуйте предметами, а Дикие духи используют свои силы, чтобы создать Вам предмет.
						\\
						Эти блоки могут быть добыты с помощью Айзниевой или Наполненной кирки.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //no text

        helper.entry("repair");
        this.add(helper.entryName(), "Ритуалы починки");

        helper.page("spotlight");
        this.add(helper.pageTitle(), "Починка");
        this.add(helper.pageText(),
                """
                        Джинн с помощью простых материалов чинит Вам мел. Развив оккультный путь, Африт может починить рудокопов, инструменты и доспехи. Следовательно, любой починенный предмет сохранит свои свойства.
                        """.formatted(COLOR_PURPLE));

        helper.page("ritual_chalks");
        //Текст отсутствует
        helper.page("ritual_miners");
        //Текст отсутствует
        helper.page("ritual_tools");
        //Текст отсутствует
        helper.page("ritual_armors");
        //Текст отсутствует
    }

    private void addFamiliarRitualsCategory(BookContextHelper helper) {
        helper.category("familiar_rituals");

        helper.entry("return_to_rituals");
        this.lang("ru_ru").add(helper.entryName(), "Вернуться в категорию ритуалов");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Ритуалы для фамильяров");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуалы для фамильяров");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Ритуалы для фамильяров вызывают духов для непосредственной помощи вызывателю. Как правило, духи обитают в теле животного. Это позволяет им защищать сущность от распада. Фамильяры дают усиления, но и могут активно защищать вызывателя.
                                """.formatted(COLOR_PURPLE));

        helper.page("ring");
        this.lang("ru_ru").add(helper.pageTitle(), "Экипировка фамильярами");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Находчивые вызыватели нашли способ заточать фамильяров в драгоценные камни, которые пассивно накладывают свои усиления. [Кольцо для фамильяра](entry://crafting_rituals/craft_familiar_ring).
                                """.formatted(COLOR_PURPLE));

        helper.page("trading");
        this.lang("ru_ru").add(helper.pageTitle(), "Экипировка фамильярами");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Фамильяры могут быть свободно торговаться, когда находятся в [Кольце для фамильяра](entry://crafting_rituals/craft_familiar_ring).
                        \\
                        \\
                        При освобождении дух признаёт того, кто его выпустил, своим новым хозяином.
                                 """.formatted(COLOR_PURPLE));

        helper.entry("familiar_bat");
        this.lang("ru_ru").add(helper.entryName(), "Летучая мышь-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Ночное зрение[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: летучая мышь-фамильяр даёт хозяину эффект «Похищение жизни».
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_beaver");
        this.lang("ru_ru").add(helper.entryName(), "Бобёр-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Повышенную скорость рубки дерева[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Бобёр-фамильяр срубает близлежащие деревья, когда они вырастут из обычного саженца в дерево. Он справляется только с малыми деревьями.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        Даёт бесплатные лакомства при нажатии ПКМ по нему пустой рукой.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_beholder");
        this.lang("ru_ru").add(helper.entryName(), "Созерцатель-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Подсвечивание врагов[#](), [#](%1$s)Стреляет **ДОЛБАНЫМИ ЛАЗЕРАМИ**[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Созерцатель-фамильяр подсвечивает близлежащих существ с помощью эффекта свечения и стреляет лазерными лучами по врагам. **Поедает** (слабые) **маленькие Шуб-Ниггураты** для получения временного урона и скорости.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: наделяет своего владельца устойчивостью к слепоте.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_blacksmith");
        this.lang("ru_ru").add(helper.entryName(), "Кузнец-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Чинит снаряжения при добыче ресурсов[#](), [#](%1$s)улучшает других фамильяров[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Всякий раз, когда игрок подбирает камень, существует вероятность, что кузнец-фамильяр немножко починит снаряжение игрока.
                        \\
                        \\
                        **Улучшение поведения**: \\
                        Не может быть улучшен, но улучшает других фамильяров.
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageTitle(), "Улучшение фамильяров");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Чтобы улучшать других фамильяров, кузнецу необходимо дать железные слитки или блоки, нажав [#](%1$s)ПКМ[#]() по нему.
                        \\
                        \\
                        Улучшенные фамильяры наделяют дополнительными эффектами.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_chimera");
        this.lang("ru_ru").add(helper.entryName(), "Химера-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Ездового, верхового животного[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Химера, чтобы вырасти, может быть накормлена каким-либо мясом. При росте она будет получать бонус к урону и скорости. Как только вырастит, игроки смогут оседлать её. Если накормить её [](item://minecraft:golden_apple), [#](%1$s)коза[#]() отчленится и станет отдельным фамильяром.
                        \\
                        \\
                        Отцеплённая коза-фамильяр может быть использована для получения [Шуб-Ниггурата-фамильяра](entry://familiar_rituals/familiar_shub_niggurath).
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: коза получит сигнальный колокол. При атаке фамильяра она позвонит в колокол и **привлечёт врагов** в пределах большого радиуса.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_cthulhu");
        this.lang("ru_ru").add(helper.entryName(), "Ктулху-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Водное дыхание[#](), [#](%1$s)хладнокровие[#]().
                               """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: служит передвижным источником света.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_shub_niggurath");
        this.lang("ru_ru").add(helper.entryName(), "Шуб-Ниггурат-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Порождения малых версий самого себя, чтобы защищать Вас[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        this.lang("ru_ru").add(helper.pageTitle(), "Ритуал");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [#](%1$s)Шуб-Ниггурат[#]() не вызывается напрямую. Сперва вызовите [Химеру-фамильяра](entry://familiar_rituals/familiar_chimera) и накормите её [](item://minecraft:golden_apple), чтобы отчленить [#](%1$s)Козу[#](). Приведите козу в [#](%1$s)Лесной биом[#](). Затем нажмите по козе с помощью [какого-либо Чёрного красителя](item://minecraft:black_dye), [](item://minecraft:flint) и [](item://minecraft:ender_eye), чтобы вызвать [#](%1$s)Шуб-Ниггурата[#]().
                           """.formatted(COLOR_PURPLE));

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: коза получит сигнальный колокол. При атаке фамильяра она позвонит в колокол и **привлечёт врагов** в пределах большого радиуса.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_deer");
        this.lang("ru_ru").add(helper.entryName(), "Олень-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Скорость, Прыгучесть и Помощь шага[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: улучшает Помощь шага и атакует близлежащих врагов молотом. Ага, **молотом**.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_devil");
        this.lang("ru_ru").add(helper.entryName(), "Дьявол-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Огнестойкость[#](), [#](%1$s)атакует врагов[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        Не может быть улучшен кузнецом-фамильяром.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_dragon");
        this.lang("ru_ru").add(helper.entryName(), "Дракон-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Повышенное получение опыта[#](), любит палочки.
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Алчные фамильяры могут оседлать дракона-фамильяра и наделять дракона эффектами алчности.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: кидает мечи на близлежащих врагов.
                           """.formatted(COLOR_PURPLE));


        helper.entry("familiar_fairy");
        this.lang("ru_ru").add(helper.entryName(), "Фея-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Помогает фамильярам[#](), [#](%1$s)предотвращает смерть фамильяра[#](), [#](%1$s)истощает жизненную силу врага[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Фея-фамильяр **оберегает от смерти других фамильяров** (с перезарядкой), выручает других фамильяров **благоприятными эффектами** и **истощает жизненную силу врагов** для помощи своему хозяину.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        Не может быть улучшена кузнецом-фамильяром.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_greedy");
        this.lang("ru_ru").add(helper.entryName(), "Алчный фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Увеличенную дальность подбирания[#](), [#](%1$s)подбирает предметы[#]().
                                   """.formatted(COLOR_PURPLE));
        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Алчный фамильяр является Фолиотом, подбирающим ближайшие предметы для хозяина. Если фамильяра поймать в кольцо, он увеличит дальность подбирания владельцу.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: сможет находить блоки для хозяина. Нажатие [#](%1$s)ПКМ[#]() по нему блоком, чтобы указать, что искать.
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_guardian");
        this.lang("ru_ru").add(helper.entryName(), "Страж-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Предотвращает смерть игрока, пока ещё живой[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Страж-фамильяр жертвует своей конечностью всякий раз, когда его хозяин близок к смерти, и благодаря этому **предотвращает смерть**. После смерти стража, игрок перестаёт быть защищённым. Будучи вызван, страж появляется со **случайным количеством конечностей**: нет гарантии, что вызовется целый страж.
                           """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: вновь приобретёт конечность (только разово).
                           """.formatted(COLOR_PURPLE));

        helper.entry("familiar_headless");
        this.lang("ru_ru").add(helper.entryName(), "Безголовый человек-крыса-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Усиление условного урона[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Безголовый человек-крыса-фамильяр похищает головы существ возле себя при убийстве монстров. Затем даёт хозяину усиление урона против того типа существа. Если здоровье человека-крысы падает **ниже 50%%** — погибает. Однако позже может быть воссоздан своим же хозяином, давая ему: [](item://minecraft:wheat), [](item://minecraft:stick), [](item://minecraft:hay_block) и [](item://minecraft:pumpkin).
                           """);

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: наделяет слабостью близлежащих монстров того же типа, чьи головы он украл.
                           """.formatted(COLOR_PURPLE));


        helper.entry("familiar_mummy");
        this.lang("ru_ru").add(helper.entryName(), "Мумия-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)эффект уклонения[#](), [#](%1$s)Сражается с врагами[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Мумия-фамильяр является мастером боевых искусств, сражающийся, чтобы защитить хозяина.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        При улучшении кузнецом-фамильяром: наносит ещё больше урона.
                            """.formatted(COLOR_PURPLE));

        helper.entry("familiar_otherworld_bird");
        this.lang("ru_ru").add(helper.entryName(), "Дрикрыл-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Мульти-прыжок[#](), [#](%1$s)прыгучесть[#](), [#](%1$s)плавное падение[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [#](%1$s)Дрикрылы[#]() — это подкласс [#](%1$s)Джинна[#](), заведомо дружелюбны к людям. Как правило, они принимают облик тёмно-синего и пурпурного цвета попугая. Дрикрылы дают владельцу ограниченные возможности полёта, будучи рядом.
                        \\
                        \\
                        **Улучшение поведения**:\\
                        Не могут быть улучшены кузнецом-фамильяром.
                            """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Чтобы получить попугая или попугая-фамильяра для жертвоприношения, попробуйте вызвать их либо с помощью [Ритуал: Дикий попугай](entry://possession_rituals/possess_unbound_parrot), или [Ритуал: Попугай-фамильяр](entry://familiar_rituals/familiar_parrot).
                        \\
                        \\
                        (**Совет:** Если Вы используете моды, защищающие питомцев от смерти, используйте Ритуал: Дикий попугай!)
                            """.formatted(COLOR_PURPLE));

        helper.entry("familiar_parrot");
        this.lang("ru_ru").add(helper.entryName(), "Попугай-фамильяр");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: [#](%1$s)Собеседника[#]().
                                   """.formatted(COLOR_PURPLE));

        helper.page("ritual");
        //текст отсутствует


        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        При проведении этого ритуала вызывается [#](%1$s)Фолиот[#]() **в качестве дикого духа**. Убийство [#](%1$s)Курицы[#]() и подношение красителей предназначается для того, чтобы склонить [#](%1$s)Фолиота[#]() принять облик попугая.
						\\
                        Хотя [#](%1$s)Фолиот[#]() не находится среди умнейших духов — в ряде случаях он дурно понимает указания...
                            """.formatted(COLOR_PURPLE));

        helper.page("description2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        *Следовательно, если появится [#](%1$s)курица[#](), это не ошибка, просто не повезло!*
                        \\
                        \\
                        **Улучшение поведения**:\\
                        Не может быть улучшены кузнецом-фамильяром.
                           """.formatted(COLOR_PURPLE));

        //текст отсутствует
        helper.entry("resurrect_allay");
        this.lang("ru_ru").add(helper.entryName(), "Очистка с Вредины до Тихони");

        helper.page("entity");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Предоставляет**: Тихоню.
                          """);

        helper.page("ritual");

        helper.page("description");
        this.lang("ru_ru").add(helper.pageTitle(), "Описание");
        this.lang("ru_ru").add(helper.pageText(),
                """
                         Очистка с Вредины до Тихони в процессе воскресения раскроет её истинное имя.
                           """.formatted(COLOR_PURPLE));

    }

    private void addStorageCategory(BookContextHelper helper) {
        helper.category("storage");
        this.lang("ru_ru").add(helper.categoryName(), "Магическое хранилище");

        helper.entry("overview");
        this.lang("ru_ru").add(helper.entryName(), "Магическое хранилище");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Магическое хранилище");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Проблема известная каждому вызывателю. Существует слишком много оккультной атрибутики, лежащей без дела. Простое решение проблемы, и всё же лучшее — Магическое хранилище!
                        \\
                        \\
                        С помощью духов можно получить доступ к пространственным хранилищам, способным создавать почти неограниченное место для хранения.
                        """.formatted(COLOR_PURPLE));

        helper.page("intro2");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Выполните следующие действия, обозначенные в этой категории, чтобы получить собственную систему хранения!
                        Действия, связанные с хранением в [Ритуалах заточения](category://crafting_rituals/) отображают только ритуалы — тогда как здесь отображены **все требуемые действия**, включая создание.
                        """.formatted(COLOR_PURPLE));

        helper.entry("storage_controller");
        this.lang("ru_ru").add(helper.entryName(), "Актуатор хранилища");

        helper.page("intro");
        this.lang("ru_ru").add(helper.pageTitle(), "Актуатор хранилища");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        [](item://occultism:storage_controller) включает в себя [Пространственную матрицу](entry://crafting_rituals/craft_dimensional_matrix), заселённую [#](%1$s)Джинном[#](), что создаёт и управляет пространственным хранилищем и [Основание](entry://crafting_rituals/craft_storage_controller_base), вселённой [#](%1$s)Фолиотом[#](), что перемещает предметы из пространственного хранилища — туда и обратно.
                        """.formatted(COLOR_PURPLE));

        helper.page("usage");
        this.lang("ru_ru").add(helper.pageTitle(), "Использование");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        После создания [](item://occultism:storage_controller) (см. на следующей странице), поставьте его на землю и нажмите [#](%1$s)ПКМ[#]() по нему пустой рукой: откроется его графический интерфейс — после чего он будет работать подобно очень большому шалкеровому ящику.
                        """.formatted(COLOR_PURPLE));

        helper.page("safety");
        this.lang("ru_ru").add(helper.pageTitle(), "Безопасность прежде всего!");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Разрушение регулятора хранилищаРазрушение регулятора хранилища сохранит все предметы при выпадении предмета: Вы ничего не потеряете.
                        То же самое касается разрушения или замены Стабилизаторов хранилища (Вы узнаете о них позже).
                        \\
                        \\
                        Подобно шалкеровому ящику, Ваши предметы в безопасности!
                        """.formatted(COLOR_PURPLE));


        helper.page("size");
        this.lang("ru_ru").add(helper.pageTitle(), "Такое огромное хранилище!");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Регулятор хранилища хранит до **128** различных типов предметов (_позже узнаете, как увеличить размер_). Помимо этого, размер суммарно ограничивается до 256.000 ед. предметов. Неважно, 256.000 ли у Вас различных предметов или 256.000 ед. одного предмета, или солянка.
                        """.formatted(COLOR_PURPLE));

        helper.page("unique_items");
        this.lang("ru_ru").add(helper.pageTitle(), "Уникальные предметы");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Предметы с уникальными свойствами ("NBT-данные"), например повреждённое или зачарованное снаряжение, занимает один тип предмета за каждое различие. Например, два деревянных меча с разными уровнями повреждений занимают два типа предмета, а два деревянных меча с одинаковым повреждением (или без) — один тип предмета.
                        """.formatted(COLOR_PURPLE));

        helper.page("config");
        this.lang("ru_ru").add(helper.pageTitle(), "Конфигурируемость");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Количество типа предмета и размер хранилища может быть настроено в "[#](%1$s)occultism-server.toml[#]()" в папке сохранения мира.
                        """.formatted(COLOR_PURPLE));

        helper.page("mods");
        this.lang("ru_ru").add(helper.pageTitle(), "Взаимодействие с модами");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Для других модов регулятор хранилища функционирует как шалкеровый ящик: всё, что может взаимодействовать с ванильными сундуками и шалкеровыми ящиками — может взаимодействовать и с регулятором хранилища.
                        Машины, которые подсчитывают содержимое хранилища, могут столкнуться с проблемами размеров стека.
                        """.formatted(COLOR_PURPLE));


        helper.page("matrix_ritual");
        //текст отсутствует

        helper.page("base_ritual");
        //текст отсутствует

        helper.page("recipe");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Это блок, который действительно функционирует как хранилище: обязательно создайте его!
                        Установка только [](item://occultism:storage_controller_base) на землю из предыдущего шага не сработает.
                        """.formatted(COLOR_PURPLE));
        //текст отсутствует


        helper.entry("storage_stabilizer");
        this.lang("ru_ru").add(helper.entryName(), "Расширение хранилища");

        helper.page("spotlight");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Стабилизаторы хранилища увеличивают размер хранилища: в пространственном хранилище Актуатора хранилища. Чем выше уровень стабилизатора, тем больше получит дополнительного хранилища. Следующие записи покажут, как создать каждый уровень.
                        \\
                        \\
                        """.formatted(COLOR_PURPLE));

        helper.page("upgrade");
        this.lang("ru_ru").add(helper.pageTitle(), "Улучшение");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Он **безопасно уничтожит стабилизатор хранилища**, чтобы улучшить его. Предметы в [Актуаторе хранилища](entry://storage/storage_controller) не будут утеряны или выброшены — Вы попросту не сможете добавлять новые предметы, пока не добавите достаточно стабилизаторов хранилища, чтобы снова иметь свободные слоты.
                         """.formatted(COLOR_PURPLE));

        helper.page("build_instructions");
        this.lang("ru_ru").add(helper.pageTitle(), "Инструкция по установке");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        Регуляторы хранилища необходимо направить на [Пространственную матрицу](entry://crafting_rituals/craft_dimensional_matrix): **один блок над [Актуатором хранилища](entry://storage/storage_controller)**.
                        \\
                        \\
                        Их может быть **до 5 блоков** в отдалении от Пространственной матрицы (должны быть по прямой линии, в зоне видимости). См. следующую страницу на предмет возможной — очень простой установки.
                        """.formatted(COLOR_PURPLE));


        helper.page("demo");
        this.lang("ru_ru").add(helper.pageTitle(), "Установка стабилизаторов хранилища");
        this.lang("ru_ru").add(helper.pageText(),
                """
                        **Примечание:** Вам не нужны все 4 стабилизатора, даже один увеличит Вам размер хранилища.
                        """.formatted(COLOR_PURPLE));
    }

    private void addAdvancements() {
        //"advancements\.occultism\.(.*?)\.title": "(.*)",
        //this.advancementTitle\("\1", "\2"\);
        this.advancementTitle("root", "Occultism");
        this.advancementDescr("root", "Принять духовность!");
        this.advancementTitle("summon_foliot_crusher", "Измельчение руд");
        this.advancementDescr("summon_foliot_crusher", "Хрусть! Хрусть! Хрусть!");
        this.advancementTitle("familiars", "Occultism: Друзья");
        this.advancementDescr("familiars", "Воспользуйтесь ритуалом для вызова фамильяра.");
        this.advancementDescr("familiar.bat", "Заманите обычную Летучую мышь близко к Летучей мыши-фамильяру.");
        this.advancementTitle("familiar.bat", "Каннибализм");
        this.advancementDescr("familiar.capture", "Заточите фамильяра в Кольцо для фамильяра.");
        this.advancementTitle("familiar.capture", "Заточить каждого!");
        this.advancementDescr("familiar.cthulhu", "Омрачите Ктулху-фамильяра.");
        this.advancementTitle("familiar.cthulhu", "Вы изверг!");
        this.advancementDescr("familiar.deer", "Посмотрите, как бобёр-фамильяр опорожняется семенами демона.");
        this.advancementTitle("familiar.deer", "Демоническая какашка");
        this.advancementDescr("familiar.devil", "Прикажите Демону-фамильяру изрыгнуть пламенем.");
        this.advancementTitle("familiar.devil", "Пламя Преисподней");
        this.advancementDescr("familiar.dragon_nugget", "Дайте кусочек золота Дракону-фамильяру.");
        this.advancementTitle("familiar.dragon_nugget", "Договорились!");
        this.advancementDescr("familiar.dragon_ride", "Позвольте Алчному фамильяру что-нибудь подобрать (при езде на Драконе-фамильяре).");
        this.advancementTitle("familiar.dragon_ride", "В тесной взаимосвязи");
        this.advancementDescr("familiar.greedy", "Позвольте Алчному фамильяру что-нибудь подобрать для Вас.");
        this.advancementTitle("familiar.greedy", "Посыльный");
        this.advancementDescr("familiar.party", "Потанцуйте с фамильяром.");
        this.advancementTitle("familiar.party", "Потанцуем!");
        this.advancementDescr("familiar.rare", "Заполучите редкий вид фамильяра.");
        this.advancementTitle("familiar.rare", "Редкий друг");
        this.advancementDescr("familiar.root", "Воспользуйтесь ритуалом, чтобы вызвать фамильяра.");
        this.advancementTitle("familiar.root", "Occultism: Друзья");
        this.advancementDescr("familiar.mans_best_friend", "Погладьте Дракона-фамильяра и поиграйте вместе в игру «Принеси мяч».");
        this.advancementTitle("familiar.mans_best_friend", "Лучший друг человека");
        this.advancementTitle("familiar.blacksmith_upgrade", "В полной боевой экипировке!");
        this.advancementDescr("familiar.blacksmith_upgrade", "Позвольте Кузнецу-фамильяру улучшить какого-нибудь из Ваших фамильяров");
        this.advancementTitle("familiar.guardian_ultimate_sacrifice", "Бескомпромиссное жертвоприношение");
        this.advancementDescr("familiar.guardian_ultimate_sacrifice", "Позвольте Стражу-фамильяру умереть ради Вас.");
        this.advancementTitle("familiar.headless_cthulhu_head", "Какой ужас!");
        this.advancementDescr("familiar.headless_cthulhu_head", "Убейте Ктулху рядом с Безголовым человеком-крысой-фамильяром.");
        this.advancementTitle("familiar.headless_rebuilt", "Мы можем восстановить Его");
        this.advancementDescr("familiar.headless_rebuilt", "\"Воссоздайте\" Безголового человека-крысу-фамильяра после его смерти.");
        this.advancementTitle("familiar.chimera_ride", "По коням!");
        this.advancementDescr("familiar.chimera_ride", "Оседлайте Химеру-фамильяра в момент её полного насыщения.");
        this.advancementTitle("familiar.goat_detach", "Демонтаж");
        this.advancementDescr("familiar.goat_detach", "Дайте Химере-фамильяру золотое яблоко.");
        this.advancementTitle("familiar.shub_niggurath_summon", "Чёрный козёл лесов");
        this.advancementDescr("familiar.shub_niggurath_summon", "Обратите Козу-фамильяра в нечто отвратительное.");
        this.advancementTitle("familiar.shub_cthulhu_friends", "Страсть к сверхъестественному");
        this.advancementDescr("familiar.shub_cthulhu_friends", "Посмотрите, как Шуб-Ниггурат и Ктулху держатся за руки.");
        this.advancementTitle("familiar.shub_niggurath_spawn", "Подумайте о детях!");
        this.advancementDescr("familiar.shub_niggurath_spawn", "Позвольте потомку Шуба-Ниггурата нанести урон по врагу взрывом.");
        this.advancementTitle("familiar.beholder_ray", "Смертельный луч");
        this.advancementDescr("familiar.beholder_ray", "Позвольте Созерцателю-фамильяру напасть на врага.");
        this.advancementTitle("familiar.beholder_eat", "Голод");
        this.advancementDescr("familiar.beholder_eat", "Посмотрите, как Созерцатель-фамильяр сжирает потомка Шуб-Ниггурата.");
        this.advancementTitle("familiar.fairy_save", "Ангел-хранитель");
        this.advancementDescr("familiar.fairy_save", "Позвольте Фее-фамильяру спасти какого-нибудь из Ваших фамильяров от неминуемой смерти.");
        this.advancementTitle("familiar.mummy_dodge", "Ниндзя!");
        this.advancementDescr("familiar.mummy_dodge", "Уклонитесь от удара за счёт эффекта уклонения Мумии-фамильяра.");
        this.advancementTitle("familiar.beaver_woodchop", "Дровосек");
        this.advancementDescr("familiar.beaver_woodchop", "Позвольте Бобру-фамильяру срубить дерево.");
		this.advancementTitle("chalks.root", "Occultism: Мелки");
        this.advancementDescr("chalks.root", "Яркий.");
        this.advancementTitle("chalks.white", "Применение белого мела");
        this.advancementDescr("chalks.white", "Для первого основания пентакля.");
        this.advancementTitle("chalks.light_gray", "Применение светло-серого мела");
        this.advancementDescr("chalks.light_gray", "Для второго основания пентакля.");
        this.advancementTitle("chalks.gray", "Применение серого мела");
        this.advancementDescr("chalks.gray", "Для третьего основания пентакля.");
        this.advancementTitle("chalks.black", "Применение чёрного мела");
        this.advancementDescr("chalks.black", "Для четвёртого основания пентакля.");
        this.advancementTitle("chalks.brown", "Применение коричневого мела");
        this.advancementDescr("chalks.brown", "На кого приманка?");
        this.advancementTitle("chalks.red", "Применение красного мела");
        this.advancementDescr("chalks.red", "Третий уровень!");
        this.advancementTitle("chalks.orange", "Применение оранжевого мела");
        this.advancementDescr("chalks.orange", "Третий уровень?");
        this.advancementTitle("chalks.yellow", "Применение жёлтого мела");
        this.advancementDescr("chalks.yellow", "Одержимость");
        this.advancementTitle("chalks.lime", "Применение лаймового мела");
        this.advancementDescr("chalks.lime", "Второй уровень.");
        this.advancementTitle("chalks.green", "Применение зелёного мела");
        this.advancementDescr("chalks.green", "Привлечение дикой природы.");
        this.advancementTitle("chalks.cyan", "Применение бирюзового мела");
        this.advancementDescr("chalks.cyan", "Древние знания.");
        this.advancementTitle("chalks.light_blue", "Применение голубого мела");
        this.advancementDescr("chalks.light_blue", "Стабилизатор дикой природы.");
        this.advancementTitle("chalks.blue", "Применение синего мела");
        this.advancementDescr("chalks.blue", "Четвёртый уровень");
        this.advancementTitle("chalks.purple", "Применение пурпурного мела");
        this.advancementDescr("chalks.purple", "Наполнение");
        this.advancementTitle("chalks.magenta", "Применение фиолетового мела");
        this.advancementDescr("chalks.magenta", "Мощь дракона");
        this.advancementTitle("chalks.pink", "Применение розового мела");
        this.advancementDescr("chalks.pink", "Сила дикой природы.");
        this.advancementTitle("chalks.rainbow", "Применение радужного мела");
        this.advancementDescr("chalks.rainbow", "Зачем столько мелов?");
        this.advancementTitle("chalks.void", "Применение пустотного мела");
        this.advancementDescr("chalks.void", "...");
    }

    private void addKeybinds() {
        this.lang("ru_ru").add("key.occultism.category", "Occultism");
        this.lang("ru_ru").add("key.occultism.backpack", "Открыть наплечную сумку");
        this.lang("ru_ru").add("key.occultism.storage_remote", "Открыть средство доступа хранилища");
        this.lang("ru_ru").add("key.occultism.familiar.otherworld_bird", "Переключение эффекта кольца: Дрикрыл");
        this.lang("ru_ru").add("key.occultism.familiar.greedy_familiar", "Переключение эффекта кольца: Алчный");
        this.lang("ru_ru").add("key.occultism.familiar.bat_familiar", "Переключение эффекта кольца: Летучая-мышь");
        this.lang("ru_ru").add("key.occultism.familiar.deer_familiar", "Переключение эффекта кольца: Олень");
        this.lang("ru_ru").add("key.occultism.familiar.cthulhu_familiar", "Переключение эффекта кольца: Ктулху");
        this.lang("ru_ru").add("key.occultism.familiar.devil_familiar", "Переключение эффекта кольца: Дьявол");
        this.lang("ru_ru").add("key.occultism.familiar.dragon_familiar", "Переключение эффекта кольца: Дракон");
        this.lang("ru_ru").add("key.occultism.familiar.blacksmith_familiar", "Переключение эффекта кольца: Кузнец");
        this.lang("ru_ru").add("key.occultism.familiar.guardian_familiar", "Переключение эффекта кольца: Страж");
        this.lang("ru_ru").add("key.occultism.familiar.headless_familiar", "Переключение эффекта кольца: Безголовый человек-крыса");
        this.lang("ru_ru").add("key.occultism.familiar.chimera_familiar", "Переключение эффекта кольца: Химера");
        this.lang("ru_ru").add("key.occultism.familiar.goat_familiar", "Переключение эффекта кольца: Коза");
        this.lang("ru_ru").add("key.occultism.familiar.shub_niggurath_familiar", "Переключение эффекта кольца: Шуб-Ниггурат");
        this.lang("ru_ru").add("key.occultism.familiar.beholder_familiar", "Переключение эффекта кольца: Созерцатель");
        this.lang("ru_ru").add("key.occultism.familiar.fairy_familiar", "Переключение эффекта кольца: Фея");
        this.lang("ru_ru").add("key.occultism.familiar.mummy_familiar", "Переключение эффекта кольца: Мумия");
        this.lang("ru_ru").add("key.occultism.familiar.beaver_familiar", "Переключение эффекта кольца: Бобёр");
    }

    private void addJeiTranslations() {
        this.lang("ru_ru").add("occultism.jei.spirit_fire", "Духовный огонь");
        this.lang("ru_ru").add("occultism.jei.crushing", "Дух-Дробильщик");
        this.lang("ru_ru").add("occultism.jei.miner", "Пространственная шахта");
        this.lang("ru_ru").add("occultism.jei.miner.chance", "Коэффициент: %d");
        this.lang("ru_ru").add("occultism.jei.ritual", "Оккультный ритуал");
        this.lang("ru_ru").add("occultism.jei.pentacle", "Пентакль");

        this.lang("ru_ru").add(TranslationKeys.JEI_CRUSHING_RECIPE_MIN_TIER, "Мин. уровень дробильщика: %d");
        this.lang("ru_ru").add(TranslationKeys.JEI_CRUSHING_RECIPE_MAX_TIER, "Макс. уровень дробильщика: %d");
        this.lang("ru_ru").add("jei.occultism.ingredient.tallow.description", "Для получения жира убивайте таких животных, как §2свиньи§r, §2коровы§r, §2овцы§r, §2лошади§r и §2ламы§r с помощью Ножа мясника.");
        this.lang("ru_ru").add("jei.occultism.ingredient.otherstone.description", "Преимущественно находится в Потусторонних рощах. Виден только тогда, когда активен эффект §6Третий глаз§r. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.otherworld_log.description", "Преимущественно находится в Потусторонних рощах. Видно только тогда, когда активен эффект §6Третий глаз§r. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.otherworld_sapling.description", "Может быть получен от Торговца потусторонними саженцами. Может быть увидено и собрано без эффекта §6Третьего глаза§r. Дополнительные сведения о том, как вызвать торговца см. в §6Справочнике душ§.");
        this.lang("ru_ru").add("jei.occultism.ingredient.otherworld_sapling_natural.description", "Преимущественно находится в Потусторонних рощах. Виден только тогда, когда активен эффект §6Третий глаз§r. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.otherworld_leaves.description", "Преимущественно находится в Потусторонних рощах. Виден только тогда, когда активен эффект §6Третий глаз§r. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.iesnium_ore.description", "Находится в Незере. Видна только тогда, когда активен эффект §6Третий глаз§r. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.spirit_fire.description", "Бросьте §6Плод видения демона§r на землю и подожгите. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.datura.description", "Может быть использована для исцеления всех духов и фамильяров, вызванные с помощью ритуалов из Occultism. Нажмите ПКМ по существу, чтобы исцелить его на одно сердце.");

        this.lang("ru_ru").add("jei.occultism.ingredient.spawn_egg.familiar_goat.description", "Коза-фамильяр может быть получена благодаря кормлению Химеры-фамильяра золотым яблоком. Дополнительные сведения см. в §6Справочнике душ§r.");
        this.lang("ru_ru").add("jei.occultism.ingredient.spawn_egg.familiar_shub_niggurath.description", "Шуб-Ниггурат-фамильяр может быть получен благодяра приводу Козы-фамильяра в лесной биом, и нажатием по ней сперва Чёрным красителем, а затем Кремнем и Оком Эндера. Дополнительные сведения см. в §6Справочнике душ§r.");

        this.lang("ru_ru").add("jei.occultism.sacrifice", "Жертва: %s");
        this.lang("ru_ru").add("jei.occultism.summon", "Вызов: %s");
        this.lang("ru_ru").add("jei.occultism.job", "Должность: %s");
        this.lang("ru_ru").add("jei.occultism.item_to_use", "Предмет использования:");
        this.lang("ru_ru").add("jei.occultism.error.missing_id", "Не удалось определить рецепт.");
        this.lang("ru_ru").add("jei.occultism.error.invalid_type", "Недействительный тип рецепта.");
        this.lang("ru_ru").add("jei.occultism.error.recipe_too_large", "Рецепт больше 3х3.");
        this.lang("ru_ru").add("jei.occultism.error.recipe_items_missing", "Отсутствующие предметы будут игнорироваться.");
        this.lang("ru_ru").add("jei.occultism.error.recipe_no_items", "Совместимые предметы для рецепта не найдены.");
        this.lang("ru_ru").add("jei.occultism.error.recipe_move_items", "Переместить предметы");
        this.lang("ru_ru").add("jei.occultism.error.pentacle_not_loaded", "Пентакль не может быть загружен.");
        this.lang("ru_ru").add("item.occultism.jei_dummy.require_sacrifice", "Требуется жертва!");
        this.lang("ru_ru").add("item.occultism.jei_dummy.require_sacrifice.tooltip", "Для запуска этого ритуала требуется жертва. Обратитесь в Справочник душ за подробными инструкциями.");
        this.lang("ru_ru").add("item.occultism.jei_dummy.require_item_use", "Требуется использовать предмет!");
        this.lang("ru_ru").add("item.occultism.jei_dummy.require_item_use.tooltip", "Для запуска этого ритуала необходимо использовать специальный предмет. Обратитесь в Справочник душ за подробными инструкциями.");
        this.lang("ru_ru").add("item.occultism.jei_dummy.none", "Результат ритуала без предмета");
        this.lang("ru_ru").add("item.occultism.jei_dummy.none.tooltip", "Этот ритуал не создаёт какие-либо предметы.");
    }

    private void addFamiliarSettingsMessages() {
        this.lang("ru_ru").add("message.occultism.familiar.otherworld_bird.enabled", "Эффект кольца — дрикрыл: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.otherworld_bird.disabled", "Эффект кольца — дрикрыл: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.greedy_familiar.enabled", "Эффект кольца — алчный: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.greedy_familiar.disabled", "Эффект кольца — алчный: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.bat_familiar.enabled", "Эффект кольца — летучая-мышь: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.bat_familiar.disabled", "Эффект кольца — летучая-мышь: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.deer_familiar.enabled", "Эффект кольца — олень: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.deer_familiar.disabled", "Эффект кольца — олень: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.cthulhu_familiar.enabled", "Эффект кольца — ктулху: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.cthulhu_familiar.disabled", "Эффект кольца — ктулху: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.devil_familiar.enabled", "Эффект кольца — дьявол: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.devil_familiar.disabled", "Эффект кольца — дьявол: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.dragon_familiar.enabled", "Эффект кольца — дракон: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.dragon_familiar.disabled", "Эффект кольца — дракон: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.blacksmith_familiar.enabled", "Эффект кольца — кузнец: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.blacksmith_familiar.disabled", "Эффект кольца — кузнец: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.guardian_familiar.enabled", "Эффект кольца — страж: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.guardian_familiar.disabled", "Эффект кольца — страж: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.headless_familiar.enabled", "Эффект кольца — безголовый человек-крыса: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.headless_familiar.disabled", "Эффект кольца — безголовый человек-крыса: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.chimera_familiar.enabled", "Эффект кольца — химера: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.chimera_familiar.disabled", "Эффект кольца — химера: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.shub_niggurath_familiar.enabled", "Эффект кольца — шуб-Ниггурат: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.shub_niggurath_familiar.disabled", "Эффект кольца — шуб-Ниггурат: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.beholder_familiar.enabled", "Эффект кольца — созерцатель: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.beholder_familiar.disabled", "Эффект кольца — созерцатель: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.fairy_familiar.enabled", "Эффект кольца — фея: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.fairy_familiar.disabled", "Эффект кольца — фея: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.mummy_familiar.enabled", "Эффект кольца — мумия: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.mummy_familiar.disabled", "Эффект кольца — мумия: ВЫКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.beaver_familiar.enabled", "Эффект кольца — бобёр: ВКЛ.");
        this.lang("ru_ru").add("message.occultism.familiar.beaver_familiar.disabled", "Эффект кольца — бобёр: ВЫКЛ.");
    }

    private void addPentacles() {
        this.addPentacle("otherworld_bird", "Потусторонняя птица");
		this.addPentacle("summon_foliot", "Круг Авиара");
		this.addPentacle("summon_djinni", "Зов Офикса");
		this.addPentacle("summon_unbound_afrit", "Вызов свободного Абраса");
		this.addPentacle("summon_afrit", "Вызов Абраса");
		this.addPentacle("summon_unbound_marid", "Вызов усиленного Абраса");
		this.addPentacle("summon_marid", "Поощряемое привлечение Фатмы");
		this.addPentacle("possess_foliot", "Приманка Гидирина");
		this.addPentacle("possess_djinni", "Порабощение Айгана");
		this.addPentacle("possess_unbound_afrit", "Повелительный вызов свободного Абраса");
		this.addPentacle("possess_afrit", "Заклятие повиновения Абраса");
		this.addPentacle("possess_marid", "Присяга Ксеоврента");
		this.addPentacle("craft_foliot", "Вынуждение призрачного Изива");
        this.addPentacle("craft_djinni", "Заточение высшего Стригора");
		this.addPentacle("craft_afrit", "Пожизненное заточение Севиры");
        this.addPentacle("craft_marid", "Перевёрнутая башня Юфиксеса");
		this.addPentacle("resurrect_spirit", "Простой круг Сасджейса");
        this.addPentacle("contact_wild_spirit", "Вызов свободного Осорина");
        this.addPentacle("contact_eldritch_spirit", "Связь с Роназом");
    }

    private void addPentacle(String id, String name) {
        this.add(Util.makeDescriptionId("multiblock", ResourceLocation.fromNamespaceAndPath(Occultism.MODID, id)), name);
    }

    private void addRitualDummies() {
		//Пользовательский макет
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_SUMMON.get(), "Пользовательский макет ритуала");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_SUMMON.get(), "Используется для сборок в качестве запасного варианта для пользовательских ритуалов, не имеющих собственного предмета для ритуала.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_POSSESS.get(), "Пользовательский макет ритуала");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_POSSESS.get(), "Используется для сборок в качестве запасного варианта для пользовательских ритуалов, не имеющих собственного предмета для ритуала.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_CRAFT.get(), "Пользовательский макет ритуала");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_CRAFT.get(), "Используется для сборок в качестве запасного варианта для пользовательских ритуалов, не имеющих собственного предмета для ритуала.");
        this.add(OccultismItems.RITUAL_DUMMY_CUSTOM_MISC.get(), "Пользовательский макет ритуала");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CUSTOM_MISC.get(), "Используется для сборок в качестве запасного варианта для пользовательских ритуалов, не имеющих собственного предмета для ритуала.");

        //Improve this
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_dimensional_matrix", "Ритуал: Создать пространственную матрицу");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_dimensional_matrix.tooltip", "Пространственная матрица — это мостик в малое пространство для хранения предметов.");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_dimensional_mineshaft", "Ритуал: Создать пространственную шахту");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_dimensional_mineshaft.tooltip", "Позволяет духам-шахтёрам входить в шахтёрское измерение и выносить обратно ресурсы.");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_infused_lenses", "Ритуал: Создать наполненные линзы");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_infused_lenses.tooltip", "Эти линзы используются для создания очков, которые дают способность видеть за пределами физического мира.");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_infused_pickaxe", "Ритуал: Создать наполненную кирку");
       this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_infused_pickaxe.tooltip", "Наполнение кирки.");

        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_djinni_ores", "Ритуал: Вызов рудного Джинна-Рудокопа");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_djinni_ores.tooltip", "Вызывайте рудного Джинна-Рудокопа в магическую лампу.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_foliot_unspecialized", "Ритуал: Вызов Фолиота-Рудокопа");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_foliot_unspecialized.tooltip", "Вызывайте Фолиота-Рудокопа в магическую лампу.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_afrit_deeps", "Ритуал: Вызов Африта-Рудокопа для глубинносланцевой руды");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_afrit_deeps.tooltip", "Вызывайте Африта-Рудокопа для глубинносланцевой руды в магическую лампу.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_marid_master", "Ритуал: Вызов мастера Марида-Рудокопа");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_miner_marid_master.tooltip", "Вызывайте мастера Марида-Рудокопа в магическую лампу.");

        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_satchel", "Ритуал: Создать необычайно большую сумку");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_satchel.tooltip", "Эта наплечная сумка позволяет хранить в себе куча предметов, чем позволяют её физические размеры. Это делает её полезным спутником для путешественника.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_soul_gem", "Ритуал: Создать камень душ");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_soul_gem.tooltip", "Камень душ позволяет временно хранить живых существ.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_familiar_ring", "Ритуал: Создать кольцо для фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_familiar_ring.tooltip", "Кольцо для фамильяра позволяет заточить фамильяров. Кольцо будет накладывать эффект фамильяра на владельца.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier1", "Ритуал: Создать стабилизатор хранилища 1-го уровня");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier1.tooltip", "Стабилизатор хранилища позволяет хранить больше предметов в средстве доступа пространственного хранилища.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier2", "Ритуал: Создать стабилизатор хранилища 2-го уровня");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier2.tooltip", "Стабилизатор хранилища позволяет хранить больше предметов в средстве доступа пространственного хранилища.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier3", "Ритуал: Создать стабилизатор хранилища 3-го уровня");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier3.tooltip", "Стабилизатор хранилища позволяет хранить больше предметов в средстве доступа пространственного хранилища.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier4", "Ритуал: Создать стабилизатор хранилища 4-го уровня");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stabilizer_tier4.tooltip", "Стабилизатор хранилища позволяет хранить больше предметов в средстве доступа пространственного хранилища.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stable_wormhole", "Ритуал: Создать стабильную червоточину");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_stable_wormhole.tooltip", "Стабильная червоточина позволяет получить доступ к пространственной матрице из удалённого место назначения.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_storage_controller_base", "Ритуал: Создать основование актуатора хранилища");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_storage_controller_base.tooltip", "Основание актуатора хранилища заключает Фолиота в матрице пространственного хранилища, отвечающего за взаимодействие с предметами.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_storage_remote", "Ритуал: Создать средство доступа хранилища");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.craft_storage_remote.tooltip", "Средство доступа хранилища может быть связано с Актуатором хранилища, чтобы получить удалённый доступа к предметам.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_otherworld_bird", "Ритуал: Вызов Дрикрыла-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_otherworld_bird.tooltip", "Дрикрылы дают владельцу ограниченные возможности полёта, будучи рядом.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_parrot", "Ритуал: Вызов Попугая-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_parrot.tooltip", "Попугай-фамильяр ведёт себя точь-в-точь как прирученные попугаи.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_greedy", "Ритуал: Вызов Алчного фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_greedy.tooltip", "Алчный фамильяр подбирает предметы для хозяина. Находясь в заключении Кольца для фамильяра, увеличивает дальность подбирания предметов (как Магнит предметов из мода Cyclic).");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_bat", "Ритуал: Вызов Летучей мыши-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_bat.tooltip", "Летучая мышь-фамильяр даёт ночное зрение хозяину.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_deer", "Ритуал: Вызов Оленя-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_deer.tooltip", "Олень-фамильяр даёт прыгучесть хозяину.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_cthulhu", "Ритуал: Вызов Ктулху-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_cthulhu.tooltip", "Ктулху-фамильяр даёт водное дыхание хозяину.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_devil", "Ритуал: Вызов Дьявола-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_devil.tooltip", "Дьявол-фамильяр даёт огнестойкость хозяину.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_dragon", "Ритуал: Вызов Дракона-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_dragon.tooltip", "Дракон-фамильяр даёт повышенное получение опыта хозяину.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_blacksmith", "Ритуал: Вызов Кузнеца-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_blacksmith.tooltip", "Кузнец-фамильяр берёт камень, добытый хозяином и использует его для починки снаряжения.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_guardian", "Ритуал: Вызов Стража-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_guardian.tooltip", "Страж-фамильяр оберегает хозяина от жестокой кончины.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_headless", "Ритуал: Вызов Безголового человека-крысы-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_headless.tooltip", "Безголовый человек-крыса-фамильяр увеличивает скорость атаки против врагов хозяина, чьи головы он украл.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_chimera", "Ритуал: Вызов Химеры-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_chimera.tooltip", "Химера-фамильяр может быть накормлена до полного роста для получения скорости атаки и урона. Как только вырастит, игроки смогут её оседлать.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_beholder", "Ритуал: Вызов Созерцателя-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_beholder.tooltip", "Созерцатель-фамильяр подсвечивает эффектом свечения близлежащих существ и стреляет лазерными лучами во врагов.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_fairy", "Ритуал: Вызов Феи-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_fairy.tooltip", "Фея-фамильяр оберегает от смерти других фамильяров, истощает жизненную силу своих врагов и исцеляет своего хозяина, а также его фамильяров.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_mummy", "Ритуал: Вызов Мумии-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_mummy.tooltip", "Мумия-фамильяр является мастером боевых искусств, сражающийся, чтобы защитить хозяина.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_beaver", "Ритуал: Вызов Бобра-фамильяра");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.familiar_beaver.tooltip", "Бобёр-фамильяр даёт повышенную скорость рубки хозяину, и добывает близлежащие деревья, когда вырастут вырастут из саженца.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_enderman", "Ритуал: Вызов Одержимого эндермена");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_enderman.tooltip", "При убийстве Одержимый эндермен всегда сбрасывает минимум один Эндер-жемчуг.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_endermite", "Ритуал: Вызов Одержимого эндермита");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_endermite.tooltip", "Одержимый эндермит сбрасывает Эндерняк.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_skeleton", "Ритуал: Вызов Одержимого скелета");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_skeleton.tooltip", "При убийстве Одержимый скелет становится устойчивым к дневному свету и всегда сбрасывает минимум один череп скелета.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_ghast", "Ритуал: Вызов Одержимого гаста");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_ghast.tooltip", "При убийстве Одержимый гаст всегда сбрасывает минимум одну слезу гаста.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_phantom", "Ритуал: Вызов Одержимого фантома");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_phantom.tooltip", "При убийстве Одержимый фантом всегда сбрасывает минимум одну мембрану фантома, но его легко поймать в ловушку.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_weak_shulker", "Ритуал: Вызов Одержимого слабого шалкера");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_weak_shulker.tooltip", "При убийстве Одержимый слабый шалкер сбрасывает минимум один плод хоруса, кроме того, может сбросить панцирь шалкера.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_shulker", "Ритуал: Вызов Одержимого шалкера");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_shulker.tooltip", "При убийстве Одержимый шалкер всегда сбрасывает минимум один панцирь шалкера.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_elder_guardian", "Ритуал: Вызов Одержимого древнего стража");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_elder_guardian.tooltip", "При убийстве Одержимый древний страж сбрасывает минимум одну раковину наутилуса, кроме того, может сбросить сердце моря и обычную добычу.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_warden", "Ритуал: Вызов Одержимого хранителя");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_warden.tooltip", "При убийстве Одержимый хранитель всегда сбрасывает минимум шесть осколков эха, кроме того, может сбросить другие древние вещи (кузнечные шаблоны и пластинки).");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_hoglin", "Ритуал: Вызов Одержимого хоглина");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_hoglin.tooltip", "При убийстве у Одержимого хоглина есть шанс сбросить Незеритовое улучшение.");
		this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_witch", "Ритуал: Вызов Одержимой ведьмы");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_witch.tooltip", "Одержимая ведьма будет сбрасывать наполненную бутылочку");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_zombie_piglin", "Ритуал: Вызов Одержимого зомбифицированного пиглина");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_zombie_piglin.tooltip", "Одержимый зомбифицированный пиглин будет сбрасывать демоническое мясо.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_bee", "Ритуал: Вызов Одержимой пчелы");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_bee.tooltip", "Одержимая пчела будет сбрасывать проклятый мёд.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_goat", "Ритуал: Вызов Козла милосердия");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_goat.tooltip", "Козёл милосердия будет сбрасывать Сущность бессердечия.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_afrit_rain_weather", "Ритуал: Дождливая погода");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_afrit_rain_weather.tooltip", "Вызывает заточённого Африта, вызывающего дождь.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_afrit_thunder_weather", "Ритуал: Гроза");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_afrit_thunder_weather.tooltip", "Вызывает заточённого Африта, вызывающего грозу.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_clear_weather", "Ритуал: Ясная погода");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_clear_weather.tooltip", "Вызывает Джинна, устраняющего погоду.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_day_time", "Ритуал: Вызов рассвета");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_day_time.tooltip", "Вызывает Джинна, устанавливающего время на полдень.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_manage_machine", "Ритуал: Вызов Джинна-Станочника");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_manage_machine.tooltip", "Станочник автоматически перемещает предметы между системой пространственного хранилища и присоединёнными инвентарями, а также машинами.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_night_time", "Ритуал: Вызов сумерек");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_djinni_night_time.tooltip", "Вызывает Джинна, устанавливающего время на сумерки.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_lumberjack", "Ритуал: Вызов Фолиота-Дровосека");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_lumberjack.tooltip", "Дровосек рубит близлежащие деревья на своём рабочем месте и кладёт выпавшие предметы в указанный сундук.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_otherstone_trader", "Ритуал: Вызов торговца потусторонним камнем");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_otherstone_trader.tooltip", "Торговец потусторонним камнем обменивает обычный камень на потусторонний.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_sapling_trader", "Ритуал: Вызов торговца потусторонними саженцами");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_sapling_trader.tooltip", "Торговец потусторонними саженцами обменивает природные потусторонние саженцы на стабильные, которые могут быть собраны без эффекта Третьего глаза.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_transport_items", "Ритуал: Вызов Фолиота-Транспортировщика");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_transport_items.tooltip", "Транспортировщик будет перемещать все предметы из одного инвентаря в другой, к которому получает доступ, включая машины.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_cleaner", "Ритуал: Вызов Фолиота-Дворника");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_foliot_cleaner.tooltip", "Дворник подбирает выпавшие предметы и кладёт их в указанный инвентарь.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_unbound_afrit", "Ритуал: Вызов незаточённого Африта");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_unbound_afrit.tooltip", "Вызывает незаточённого Африта, который может быть убит для получения Сущности Африта.");
		this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_unbound_marid", "Ритуал: Вызов незаточённого Марида");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.summon_unbound_marid.tooltip", "Вызывает незаточённого Марида, который может быть убит для получения Сущности Марида.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.wild_hunt", "Ритуал: Вызов Дикой Охоты");
		this.add("item.occultism.ritual_dummy.summon_unbound_marid.tooltip", "Вызывает незаточённого Марида, который может быть убит для получения Сущности Марида.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_unbound_otherworld_bird", "Ритуал: Овладение несвязанным дрикрылом");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_unbound_otherworld_bird.tooltip", "Завладевает Дрикрылом-фамильяром, который может быть приручен кем угодно, не только вызывателем.");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_unbound_parrot", "Ритуал: Овладение несвязанным попугаем");
        this.lang("ru_ru").add("item.occultism.ritual_dummy.possess_unbound_parrot.tooltip", "Завладевает попугаем, который может быть приручен кем угодно, не только вызывателем.");

        this.add("item.occultism.ritual_dummy.craft_nature_paste", "Ритуал: Создание природной пасты");
        this.add("item.occultism.ritual_dummy.craft_nature_paste.tooltip", "Смешав ингредиенты, Фолиот создаст природную пасту.");
        this.add("item.occultism.ritual_dummy.craft_gray_paste", "Ритуал: Создание серой пасты");
        this.add("item.occultism.ritual_dummy.craft_gray_paste.tooltip", "Смешав ингредиенты, Джинн создаст серую пасту.");
        this.add("item.occultism.ritual_dummy.craft_research_fragment_dust", "Ритуал: Создать пыль фрагмента исследования");
        this.add("item.occultism.ritual_dummy.craft_research_fragment_dust.tooltip", "Фолиот наполнит опыт в изумрудную пыль.");
        this.add("item.occultism.ritual_dummy.craft_witherite_dust", "Ритуал: Создать визеритовую пыль");
        this.add("item.occultism.ritual_dummy.craft_witherite_dust.tooltip", "Африт наполнит незеритовую пыль в Сущность визера.");
        this.add("item.occultism.ritual_dummy.craft_dragonyst_dust", "Ритуал: Создать драконистовую пыль");
        this.add("item.occultism.ritual_dummy.craft_dragonyst_dust.tooltip", "Марид наполнит Сущность Эндер-Дракона в аметистовую пыль.");
        this.add("item.occultism.ritual_dummy.repair_chalks", "Ритуал: Починка мела");
        this.add("item.occultism.ritual_dummy.repair_chalks.tooltip", "Полностью починит мел, вселив в него Джинна.");
        this.add("item.occultism.ritual_dummy.repair_tools", "Ритуал: Починка инструмента");
        this.add("item.occultism.ritual_dummy.repair_tools.tooltip", "Полностью починит инструмент, вселив в него Африта.");
        this.add("item.occultism.ritual_dummy.repair_armors", "Ритуал: Починка брони");
        this.add("item.occultism.ritual_dummy.repair_armors.tooltip", "Полностью починит броню, вселив в неё Африта.");
        this.add("item.occultism.ritual_dummy.repair_miners", "Ритуал: Восстановление рудокопа");
        this.add("item.occultism.ritual_dummy.repair_miners.tooltip", "Продлит договор, заключив сделку с Афритом.");

        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER.get(), "Ритуал: Вызов Дробильщика-Фолиота");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_CRUSHER.get(), "Дробильщик — дух, вызываемый для размельчения руды в пыль, эффективно (гораздо), удваивая металлопродукцию." + ChatFormatting.GRAY + ChatFormatting.ITALIC + "§7§oПримечание: некоторые рецепты могут требовать высокий или низкий уровень дробильщиков.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER.get(), "Ритуал: Вызов Джинна-Дробильщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_CRUSHER.get(), "Дробильщик — дух, вызываемый для размельчения руды в пыль, эффективно (гораздо), удваивая металлопродукцию." + ChatFormatting.GRAY + ChatFormatting.ITALIC + "§7§oПримечание: некоторые рецепты могут требовать высокий или низкий уровень дробильщиков.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER.get(), "Ритуал: Вызов Африта-Дробильщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_CRUSHER.get(), "Дробильщик — дух, вызываемый для размельчения руды в пыль, эффективно (гораздо), удваивая металлопродукцию." + ChatFormatting.GRAY + ChatFormatting.ITALIC + "§7§oПримечание: некоторые рецепты могут требовать высокий или низкий уровень дробильщиков.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER.get(), "Ритуал: Вызов Марида-Дробильщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_CRUSHER.get(), "Дробильщик — дух, вызываемый для размельчения руды в пыль, эффективно (гораздо), удваивая металлопродукцию." + ChatFormatting.GRAY + ChatFormatting.ITALIC + "§7§oПримечание: некоторые рецепты могут требовать высокий или низкий уровень дробильщиков.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER.get(), "Ритуал: Вызов Фолиота-Литейщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_FOLIOT_SMELTER.get(), "Литейщик — дух, вызываемый для создания рецептов печи без использования топлива.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER.get(), "Ритуал: Вызов Джинна-Литейщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_DJINNI_SMELTER.get(), "Литейщик — дух, вызываемый для создания рецептов печи без использования топлива.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER.get(), "Ритуал: Вызов Африта-Литейщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_AFRIT_SMELTER.get(), "Литейщик — дух, вызываемый для создания рецептов печи без использования топлива.");
        this.add(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER.get(), "Ритуал: Вызов Марида-Литейщика");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_MARID_SMELTER.get(), "Литейщик — дух, вызываемый для создания рецептов печи без использования топлива.");
        this.lang("ru_ru").add(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_WIFE.get(), "Ритуал: Вызов демонической жены");
        this.lang("ru_ru").addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_WIFE.get(), "Вызывает демоническую жену для поддержки: она будет защищать Вас, помогать с готовкой и продлевать продолжительность зелья.");
        this.lang("ru_ru").add(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_HUSBAND.get(), "Ритуал: Вызов демонического мужа");
        this.lang("ru_ru").addTooltip(OccultismItems.RITUAL_DUMMY_SUMMON_DEMONIC_HUSBAND.get(), "Вызывает демонического мужа для поддержки: он будет защищать Вас, помогать с готовкой и продлевать продолжительность зелья.");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_COMMON.get(), "Ритуал: Вызов обычного случайного животного");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_COMMON.get(), "Вызывает случайное пассивное обычное животное. (Все варианты: курица, корова, свинья, овца, спрут и волк).");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_WATER.get(), "Ритуал: Вызов водного случайного животного");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_WATER.get(), "Вызывает случайное пассивное водяное животное. (Все варианты: аксолотль, лягушка, дельфин, треска, лосось, тропическая рыба, иглобрюх, спрут, светящийся спрут, головастик, черепаха и снежный голем).");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SMALL.get(), "Ритуал: Вызов малого случайного животного");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SMALL.get(), "Вызывает случайное пассивное малое животное. (Все варианты: тихоня, летучая мышь, пчела, попугай, кошка, оцелот, лиса и кролик).");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SPECIAL.get(), "Ритуал: Вызов специального случайного животного");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_SPECIAL.get(), "Вызывает случайное пассивное специальное животное. (Все варианты: броненосец, муушрум, панда, белый медведь и коза, железный голем и нюхач).");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_RIDEABLE.get(), "Ритуал: Вызов ездового случайного животного");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_RANDOM_ANIMAL_RIDEABLE.get(), "Вызывает случайное пассивное ездовое животное. (Все варианты: свинья, верблюд, осёл, лошадь, скелет, зомби-лошадь, лама, лама торговца, мул и лавомерка).");
        this.add(OccultismItems.RITUAL_DUMMY_POSSESS_VILLAGER.get(), "Ритуал: Вызов крестьянина");
		this.add(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM.get(), "Ритуал: Вызов Айзниевого голема");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_IESNIUM_GOLEM.get(), "Вызывает сильного и неуязвимого айзниевого голема для защиты территории.");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_POSSESS_VILLAGER.get(), "Вызывает Крестьянина или Странствующего торговца.");
        this.add(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1.get(), "Ритуал: Создать ритуальную наплечную сумку подмастерья");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T1.get(), "Заточает Фолиота в наплечную сумку для пошаговой постройки пентаклей в пользу вызывателя.");
        this.add(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2.get(), "Ритуал: Создать ремесленную ритуальную наплечную сумку");
        this.add(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL.get(), "Ритуал: Создать жертвенную миску из айзния");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_SACRIFICIAL_BOWL.get(), "Айзниевая жертвенная миска выполняет любой ритуал за черверть расчётного времени. Остальные особенности действуют аналогично Золотой жертвенной миски.");
        this.add(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL.get(), "Ритуал: Создать наковальню из айзния");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CRAFT_IESNIUM_ANVIL.get(), "Айзниевая наковальня — достижение по сравнению с обычной наковальней. Все её преимущества смотрите в Справочнике душ.");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_CRAFT_RITUAL_SATCHEL_T2.get(), "Заточает Африта в наплечную сумку для мгновенной постройки пентаклей в пользу вызывателя.");

		//Misc dummy
        this.add(OccultismItems.RITUAL_DUMMY_RESURRECT_FAMILIAR.get(), "Ритуал: Воскресение фамильяра");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_RESURRECT_FAMILIAR.get(), "Воскрешает фамильяра из Осколка души.");

        this.add(OccultismItems.RITUAL_DUMMY_RESURRECT_ALLAY.get(), "Ритуал: Очистка с Вредины до Тихони");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_RESURRECT_ALLAY.get(), "Очищает с Вредины до Тихони.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_HUNT.get(), "Ритуал: Вызов Дикой Охоты");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_HUNT.get(), "Дикая Охота состоит из Визер-скелетов и их прислужников, с которых есть большой шанс получить черепа визер-скелетов и их прислужников.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_HUSK.get(), "Ритуал: Вызов орды диких кадавров");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_HUSK.get(), "Орда диких кадавров состоит из несколько Кадавров, с которых выпадают предметы, связанные с испытаниями пустыни.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_DROWNED.get(), "Ритуал: Вызов орды диких утопленников");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_DROWNED.get(), "Орда диких утопленников состоит из несколько Утопленников, с которых выпадают предметы, связанные с испытаниями океана.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_CREEPER.get(), "Ритуал: Вызов орды диких криперов");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_CREEPER.get(), "Орда диких криперов состоит из несколько заряженных Криперов, с которых выпадает много пластинок.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_SILVERFISH.get(), "Ритуал: Вызов орды диких чешуйниц");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_SILVERFISH.get(), "Орда диких чешуйниц состоит из несколько чешуйниц, с которых выпадают предметы, связанные с испытаниями руин.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_WEAK_BREEZE.get(), "Ритуал: Вызов дикого слабого вихря");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_WEAK_BREEZE.get(), "Дикий слабый вихрь будет сбрасывать Ключ испытаний и предметы, связанные с камерой испытаний.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_BREEZE.get(), "Ритуал: Вызов дикого вихря");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_BREEZE.get(), "Дикий вихрь будет сбрасывать Зловещий ключ испытаний и предметы, связанные с камерой испытаний.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_STRONG_BREEZE.get(), "Ритуал: Вызов дикого сильного вихря");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_STRONG_BREEZE.get(), "Дикий сильный вихрь будет сбрасывать Навершие булавы и предметы, связанные с камерой испытаний.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_ILLAGER.get(), "Ритуал: Вызов диких разбойников");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_ILLAGER.get(), "Вызывает Дикого заклинателя и его приспешника.");

        this.add(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_COMMON.get(), "Ритуал: Вызов группы случайных обычных животных");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_COMMON.get(), "Вызывает группу случайных пассивных обычных животных. (Все варианты: курица, корова, свинья, овца, спрут и волк).");
        this.add(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_WATER.get(), "Ритуал: Вызов группы случайных водяных животных");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_WATER.get(), "Вызывает группу случайных пассивных водяных животных. (Все варианты: аксолотль, лягушка, дельфин, треска, лосось, тропическая рыба, иглобрюх, спрут, светящийся спрут, головастик, черепаха и снежный голем).");
        this.add(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SMALL.get(), "Ритуал: Вызов группы случайных малых животных");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SMALL.get(), "Вызывает группу случайных пассивных малых животных. (Все варианты: тихоня, летучая мышь, пчела, попугай, кошка, оцелот, лиса и кролик).");
        this.add(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SPECIAL.get(), "Ритуал: Вызов группы случайных специальных животных");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_SPECIAL.get(), "Вызывает группу случайных пассивных специальных животных. (Все варианты: броненосец, муушрум, панда, белый медведь, коза, железный голем и нюхач).");
        this.add(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_RIDEABLE.get(), "Ритуал: Вызов группы случайных ездовых животных");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_RANDOM_ANIMAL_RIDEABLE.get(), "Вызывает группу случайных пассивных ездовых животных. (Все варианты: свинья, верблюд, осёл, лошадь, лошадь-скелет, зомби-лошадь, лама, лама торговца, мул и лавомерка).");
        this.add(OccultismItems.RITUAL_DUMMY_WILD_VILLAGER.get(), "Ритуал: Вызов группы крестьян");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_WILD_VILLAGER.get(), "Вызывает группу крестьян и одного странствующего торговца.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_WILD_TRIM.get(), "Ритуал: Кузнечный шаблон");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_WILD_TRIM.get(), "Дикие духи создадут Кузнечный шаблон.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST.get(), "Ритуал: Создание цветущего аметиста");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_BUDDING_AMETHYST.get(), "Дикие духи создадут цветущий аметист.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE.get(), "Ритуал: Создание укреплённого глубинного сланца");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_REINFORCED_DEEPSLATE.get(), "Дикие духи создадут укреплённый глубинный сланец.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST.get(), "Ритуал: Создание пчелиного гнезда");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_BEE_NEST.get(), "Дикие духи создадут пчелиное гнездо, более эстетичнее пчелиного улья.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_BELL.get(), "Ритуал: Создание колокола");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_BELL.get(), "Дикие духи создадут колокол.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_MINER_ANCIENT_ELDRITCH.get(), "Ритуал: Вызов сверхъестественного древнего рудокопа");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_MINER_ANCIENT_ELDRITCH.get(), "Вызывайте сверхъестественного древнего рудокопа в магическую лампу.");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE.get(), "Ритуал: Создание сверхъестественного потира");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_ELDRITCH_CHALICE.get(), "Сверхъестественные духи создадут Сверхъестественный потир, мгновенно выполняющий любые ритуалы, — вот Ваш трофей!");

        this.add(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE.get(), "Ритуал: Создание актуатора стабилизатора пространственного хранилища");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_STABILIZED_STORAGE.get(), "Сверхъестественные духи создадут стабилизированный актуатор пространственного хранилища. Работает как актуатор с максимальным количеством стабилизаторов, занимая всего один блок.");
		
        this.add(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW.get(), "Ритуал: Создание радужного мела");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_RAINBOW.get(), "Сверхъестественные духи создадут радужный мел, используемый вместо любого цветного мела.");
        this.add(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID.get(), "Ритуал: Создание пустотного мела");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_CHALK_VOID.get(), "Сверхъестественные духи создадут радужный мел, применяемый вместо любого мела.");
		this.add(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM.get(), "Ритуал: Создание камня Троицы");
        this.addTooltip(OccultismItems.RITUAL_DUMMY_FORGE_TRINITY_GEM.get(), "Сверхъестественные духи создадут камень Троицы, усовершенствуя Камень душ.");
    }

    public void addTooltip(ItemLike key, String value) {
        this.add(key.asItem().getDescriptionId() + ".tooltip", value);
    }

    public void addAutoTooltip(ItemLike key, String value) {
        this.add(key.asItem().getDescriptionId() + ".auto_tooltip", value);
    }

    private void addDialogs() {
        this.lang("ru_ru").add("dialog.occultism.dragon.pet", "Мурчанье");
        this.lang("ru_ru").add("dialog.occultism.mummy.kapow", "БУМ!");
        this.lang("ru_ru").add("dialog.occultism.beaver.snack_on_cooldown", "Эй, не жадничай!");
        this.lang("ru_ru").add("dialog.occultism.beaver.no_upgrade", "Кузнецу-фамильяру нужно улучшить Созерцателя, прежде чем он будет разбрасываться лакомствами!");
    }

    private void addModonomiconIntegration() {
        this.lang("ru_ru").add(I18n.RITUAL_RECIPE_ITEM_USE, "Использование предмета:");
        this.lang("ru_ru").add(I18n.RITUAL_RECIPE_SUMMON, "Вызов: %s");
        this.lang("ru_ru").add(I18n.RITUAL_RECIPE_JOB, "Должность: %s");
        this.lang("ru_ru").add(I18n.RITUAL_RECIPE_SACRIFICE, "Жертва: %s");
        this.lang("ru_ru").add(I18n.RITUAL_RECIPE_GO_TO_PENTACLE, "Открыть страницу пентакля: %s");
    }

    private void advancementTitle(String name, String s) {
        this.add(((TranslatableContents) OccultismAdvancementSubProvider.title(name).getContents()).getKey(), s);
    }

    private void advancementDescr(String name, String s) {
        this.add(((TranslatableContents) OccultismAdvancementSubProvider.descr(name).getContents()).getKey(), s);
    }

    private void addTags() {
        // Теги блока
        this.addBlockTag(OccultismTags.Blocks.OTHERWORLD_SAPLINGS, "Потусторонние саженцы");
		this.addBlockTag(OccultismTags.Blocks.OTHERWORLD_SAPLINGS_NATURAL, "Саженцы потустороннего мира_NATURAL");
        this.addBlockTag(OccultismTags.Blocks.CANDLES, "Свечи");
        this.addBlockTag(OccultismTags.Blocks.CAVE_WALL_BLOCKS, "Пещерная ограда");
        this.addBlockTag(OccultismTags.Blocks.NETHERRACK, "Незерак");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_STABILIZER, "Стабилизатор хранилища");
        this.addBlockTag(OccultismTags.Blocks.TREE_SOIL, "Почва для дерева");
        this.addBlockTag(OccultismTags.Blocks.WORLDGEN_BLACKLIST, "Чёрный список блоков генерации мира");
        this.addBlockTag(OccultismTags.Blocks.IESNIUM_ORE, "Руда айзния");
        this.addBlockTag(OccultismTags.Blocks.SILVER_ORE, "Серебряная руда");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_IESNIUM, "Хранилище айзниевых блоков");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_SILVER, "Хранилище серебряный блоков");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_RAW_IESNIUM, "Хранилище рудных блоков айзния");
        this.addBlockTag(OccultismTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, "Хранилище рудных блоков серебра");


        // Теги предмета
        this.addItemTag(OccultismTags.Items.OTHERWORLD_SAPLINGS, "Потусторонние саженцы");
		this.addItemTag(OccultismTags.Items.OTHERWORLD_SAPLINGS_NATURAL, "Природные потусторонние саженцы");
        this.addItemTag(OccultismTags.Items.BOOK_OF_CALLING_DJINNI, "Книга вызова Джинна");
        this.addItemTag(OccultismTags.Items.BOOK_OF_CALLING_FOLIOT, "Книга вызова Фолиота");
		this.addItemTag(OccultismTags.Items.BOOKS_OF_BINDING, "Книги привязки");
        this.addItemTag(OccultismTags.Items.Miners.BASIC_RESOURCES, "Рудокопы базовых ресурсов");
        this.addItemTag(OccultismTags.Items.Miners.DEEPS, "Рудокопы глубинносланца");
        this.addItemTag(OccultismTags.Items.Miners.MASTER, "Рудокопы редких ресурсов");
		this.addItemTag(OccultismTags.Items.Miners.ELDRITCH, "Сверхъестественные рудокопы");
        this.addItemTag(OccultismTags.Items.Miners.ORES, "Основные рудокопы");
        this.addItemTag(OccultismTags.Items.ELYTRA, "Элитры");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_GOGGLES, "Потусторонние очки");
        this.addItemTag(OccultismTags.Items.DATURA_SEEDS, "Семена видения демона");
        this.addItemTag(OccultismTags.Items.DATURA_CROP, "Видение демона");
        this.addItemTag(OccultismTags.Items.COPPER_DUST, "Медная пыль");
        this.addItemTag(OccultismTags.Items.GOLD_DUST, "Золотая пыль");
        this.addItemTag(OccultismTags.Items.IESNIUM_DUST, "Айзниевая пыль");
        this.addItemTag(OccultismTags.Items.IRON_DUST, "Железная пыль");
        this.addItemTag(OccultismTags.Items.SILVER_DUST, "Серебряная пыль");
        this.addItemTag(OccultismTags.Items.END_STONE_DUST, "Измельчённый эндерняк");
        this.addItemTag(OccultismTags.Items.OBSIDIAN_DUST, "Измельчённый обсидиан");
        this.addItemTag(OccultismTags.Items.IESNIUM_INGOT, "Айзниевый слиток");
        this.addItemTag(OccultismTags.Items.SILVER_INGOT, "Серебряный слиток");
        this.addItemTag(OccultismTags.Items.IESNIUM_NUGGET, "Кусочек айзния");
        this.addItemTag(OccultismTags.Items.SILVER_NUGGET, "Кусочек серебра");
        this.addItemTag(OccultismTags.Items.IESNIUM_ORE, "Руда айзния");
        this.addItemTag(OccultismTags.Items.SILVER_ORE, "Серебряная руда");
        this.addItemTag(OccultismTags.Items.RAW_IESNIUM, "Рудный айзний");
        this.addItemTag(OccultismTags.Items.RAW_SILVER, "Рудное серебро");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_IESNIUM, "Хранилище блоков айзния");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_SILVER, "Хранилище серебряный блоков");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_RAW_IESNIUM, "Хранилище блоков рудного айзния");
        this.addItemTag(OccultismTags.Items.STORAGE_BLOCK_RAW_SILVER, "Хранилище блоков серебра");
		this.addItemTag(OccultismTags.Items.MUSHROOM_BLOCKS, "Грибные блоки");
        this.addItemTag(OccultismTags.Items.TALLOW, "Жир");
        this.addItemTag(OccultismTags.Items.METAL_AXES, "Металлические топоры");
        this.addItemTag(OccultismTags.Items.MAGMA, "Магма");
        this.addItemTag(OccultismTags.Items.BOOKS, "Книги");
        this.addItemTag(OccultismTags.Items.FRUITS, "Фрукты");
		this.addItemTag(OccultismTags.Items.AMETHYST_DUST, "Аметистовая пыль");
        this.addItemTag(OccultismTags.Items.BLACKSTONE_DUST, "Чернитная пыль");
        this.addItemTag(OccultismTags.Items.BLUE_ICE_DUST, "Пыль из синего льда");
        this.addItemTag(OccultismTags.Items.CALCITE_DUST, "Кальцитовая пыль");
        this.addItemTag(OccultismTags.Items.ICE_DUST, "Пыль из синего льда");
        this.addItemTag(OccultismTags.Items.PACKED_ICE_DUST, "Пыль из плотного льда");
        this.addItemTag(OccultismTags.Items.DRAGONYST_DUST, "Драконистовая пыль");
        this.addItemTag(OccultismTags.Items.ECHO_DUST, "Пыль эхо");
        this.addItemTag(OccultismTags.Items.EMERALD_DUST, "Изумрудная пыль");
        this.addItemTag(OccultismTags.Items.LAPIS_DUST, "Лазуритовая пыль");
        this.addItemTag(OccultismTags.Items.NETHERITE_DUST, "Незеритовая пыль");
        this.addItemTag(OccultismTags.Items.NETHERITE_SCRAP_DUST, "Пыль из незеритового осколка");
        this.addItemTag(OccultismTags.Items.RESEARCH_DUST, "Пыль исследования");
        this.addItemTag(OccultismTags.Items.WITHERITE_DUST, "Визеритовая пыль");
        this.addItemTag(OccultismTags.Items.OTHERSTONE_DUST, "Пыль из потустороннего камня");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_WOOD_DUST, "Потусторонняя древесная пыль");
        this.addItemTag(OccultismTags.Items.OCCULTISM_CANDLES, "Occultism-свечи");
        this.addItemTag(OccultismTags.Items.Miners.MINERS, "Рудокопы в пространствах");
		this.addItemTag(OccultismTags.Items.SCUTESHELL, "Щиток или Панцирь");
		this.addItemTag(OccultismTags.Items.BLAZE_DUST, "Пылающая пыль");
        this.addItemTag(OccultismTags.Items.MANUALS, "Руководства");
		this.addItemTag(OccultismTags.Items.TOOLS_KNIFE, "Ножи");
		this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "belt"), "Пояса");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "hands"), "Руки");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "heads"), "Головы");
        this.addItemTag(ResourceLocation.fromNamespaceAndPath("curios", "ring"), "Кольцо");
        this.addItemTag(OccultismTags.Items.DEMONIC_PARTNER_FOOD, "Пища для демонического партнёра");
        this.addItemTag(OccultismTags.Items.OTHERCOBBLESTONE, "Потусторонний булыжник");
        this.addItemTag(OccultismTags.Items.OTHERSTONE, "Потусторонний камень");
        this.addItemTag(OccultismTags.Items.OTHERWORLD_LOGS, "Потусторонние брёвна");
        this.addItemTag(OccultismTags.Items.PENTACLE_MATERIALS, "Материалы для пентакля");
        this.addItemTag(OccultismTags.Items.TOOLS_CHALK, "Мелы");
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
        this.lang("ru_ru").add("emi.category.occultism.spirit_fire", "Духовный огонь");
        this.lang("ru_ru").add("emi.category.occultism.crushing", "Размельчение");
        this.lang("ru_ru").add("emi.category.occultism.miner", "Пространственная шахта");
        this.lang("ru_ru").add("emi.category.occultism.ritual", "Ритуалы");
        this.lang("ru_ru").add("emi.occultism.item_to_use", "Предмет использования: %s");
    }

	private void addConditionMessages() {
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_TYPE_NOT_FULFILLED, "Выполните ритуал в измерении «%s»! Он был выполнен в %s.");
		this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_TYPE_DESCRIPTION, "Нужно выполнить в измерении «%s».");
		
		this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_NOT_FULFILLED, "Выполните ритуал в измерении «%s»! Он был выполнен в %s.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_DIMENSION_DESCRIPTION, "Нужно выполнить в измерении «%s».");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_NOT_FULFILLED, "Выполните ритуал в биоме «%s»! Он был выполнен в %s.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_DESCRIPTION, "Нужно выполнить в биоме «%s».");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_WITH_TAG_NOT_FULFILLED, "Выполните ритуал в биоме с тегом «%s»! Он был выполнен в биоме «%s», у которого отсутствует тег.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.IS_IN_BIOME_WITH_TAG_DESCRIPTION, "Нужно выполнить в биоме с тегом %s.");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.AND_NOT_FULFILLED, "Один или несколько из требуемых условий не были удовлетворены (всё должно быть удовлетворено): %s");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.AND_DESCRIPTION, "Нужно удовлетворить все нижеследующие условия: %s");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.OR_NOT_FULFILLED, "Ни один из требуемых условий не были удовлетворены (должно быть удовлетворено минимум одно): %s");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.OR_DESCRIPTION, "Нужно выполнить минимум один из следующих условий: %s");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.TRUE_NOT_FULFILLED, "Постоянное Выполняемое условие по тем или иным причинам не выполняется. Такого никогда не должно происходить.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.TRUE_DESCRIPTION, "Это условие всегда выполняется.");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.FALSE_NOT_FULFILLED, "Это Условие никогда не выполняется. Используйте другое условие в рецепте, чтобы сделать ритуал рабочим.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.FALSE_DESCRIPTION, "Это условие никогда не выполняется.");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.NOT_NOT_FULFILLED, "Условие было удовлетворено, но не должно удовлетворяться: %s");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.NOT_DESCRIPTION, "Следующее условие не должно удовлетворяться: %s");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.ITEM_EXISTS_NOT_FULFILLED, "Предмет «%s» не существует.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.ITEM_EXISTS_DESCRIPTION, "Должен существовать предмет «%s».");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.MOD_LOADED_NOT_FULFILLED, "Мод «%s» не загружен.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.MOD_LOADED_DESCRIPTION, "Мод «%s» должен быть загружен.");

        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.TAG_EMPTY_NOT_FULFILLED, "Тег %s не пустой.");
        this.lang("ru_ru").add(TranslationKeys.Condition.Ritual.TAG_EMPTY_DESCRIPTION, "Тег %s должен быть пустым.");
    }

    private void addConfigurationTranslations() {
        this.addConfig("visual", "Визуальные настройки");
        this.addConfig("showItemTagsInTooltip", "Показывать теги предмета в подсказках");
        this.addConfig("disableDemonsDreamShaders", "Отключить шейдеры для Видения демона");
        this.addConfig("disableHolidayTheming", "Отключить шейдеры для Потусторонних очков");
        this.addConfig("useAlternativeDivinationRodRenderer", "Использовать альтернативный отрисовщик для Стержня прорицания");
        this.addConfig("whiteChalkGlyphColor", "Цвет белого мела");
        this.addConfig("yellowChalkGlyphColor", "Цвет жёлтого мела");
        this.addConfig("purpleChalkGlyphColor", "Цвет пурпурного мела");
        this.addConfig("redChalkGlyphColor", "Цвет красного мела");
		this.addConfig("lightGrayChalkGlyphColor", "Цвет светло-серого глифа");
        this.addConfig("grayChalkGlyphColor", "Цвет серого глифа");
        this.addConfig("blackChalkGlyphColor", "Цвет чёрного глифа");
        this.addConfig("brownChalkGlyphColor", "Цвет коричневого глифа");
        this.addConfig("orangeChalkGlyphColor", "Цвет оранжевого глифа");
        this.addConfig("limeChalkGlyphColor", "Цвет лаймового глифа");
        this.addConfig("greenChalkGlyphColor", "Цвет зелёного глифа");
        this.addConfig("cyanChalkGlyphColor", "Цвет бирюзового глифа");
        this.addConfig("lightBlueChalkGlyphColor", "Цвет голубого глифа");
        this.addConfig("blueChalkGlyphColor", "Цвет синего глифа");
        this.addConfig("magentaChalkGlyphColor", "Цвет фиолетового глифа");
        this.addConfig("pinkChalkGlyphColor", "Цвет розового глифа");

        this.addConfig("misc", "Прочие настройки");
        this.addConfig("syncJeiSearch", "Синхронизировать поиск с JEI");
        this.addConfig("divinationRodHighlightAllResults", "Подсвечивать все результаты Стержнем прорицания");
        this.addConfig("divinationRodScanRange", "Радиус сканирования Жезла прорицания");
        this.addConfig("disableSpiritFireSuccessSound", "Отключить звук успешности для Духовного огня");

        this.addConfig("storage", "Настройки хранилища");
        this.addConfig("stabilizerTier1AdditionalMaxItemTypes", "Макс. доп. типов предметов в стабилизаторе 1-го уровня");
        this.addConfig("stabilizerTier1AdditionalMaxTotalItemCount", "Макс. доп. общего количества предметов в стабилизаторе 1-го уровня");
        this.addConfig("stabilizerTier2AdditionalMaxItemTypes", "Макс. доп. типов предметов в стабилизаторе 2-го уровня");
        this.addConfig("stabilizerTier2AdditionalMaxTotalItemCount", "Макс. доп. общего количества предметов в стабилизаторе 2-го уровня");
        this.addConfig("stabilizerTier3AdditionalMaxItemTypes", "Макс. доп. типов предметов в стабилизаторе 3-го уровня");
        this.addConfig("stabilizerTier3AdditionalMaxTotalItemCount", "Макс. доп. общего количества предметов в стабилизаторе 3-го уровня");
        this.addConfig("stabilizerTier4AdditionalMaxItemTypes", "Макс. доп. типов предметов в стабилизаторе 4-го уровня");
        this.addConfig("stabilizerTier4AdditionalMaxTotalItemCount", "Макс. доп. общего количества предметов в стабилизаторе 4-го уровня");
        this.addConfig("controllerMaxItemTypes", "Макс. типов предметов в регуляторе");
        this.addConfig("controllerMaxTotalItemCount", "Макс. общее количество предмета в регуляторе");
		this.addConfig("stabilizedControllerStabilizers", "Stabilized Controller Built-in Stabilizers");
        this.addConfig("unlinkWormholeOnBreak", "Отвязывать червоточину при разрушении");

        this.addConfig("spirit_job", "Настройки должности духа");
        this.addConfig("drikwingFamiliarSlowFallingSeconds", "Продолжительность (в секундах) эффекта Плавного падения, полученное благодаря Дрикрылу-фамильяру.");
        this.addConfig("tier1CrusherTimeMultiplier", "Коэффициент времени для операций дробильщика 1-го уровня.");
        this.addConfig("tier2CrusherTimeMultiplier", "Коэффициент времени для операций дробильщика 2-го уровня.");
        this.addConfig("tier3CrusherTimeMultiplier", "Коэффициент времени для операций дробильщика 3-го уровня.");
        this.addConfig("tier4CrusherTimeMultiplier", "Коэффициент времени для операций дробильщика 4-го уровня.");
        this.addConfig("tier1CrusherOutputMultiplier", "Коэффициент продукции для операций дробильщика 1-го уровня.");
        this.addConfig("tier2CrusherOutputMultiplier", "Коэффициент продукции для операций дробильщика 2-го уровня.");
        this.addConfig("tier3CrusherOutputMultiplier", "Коэффициент продукции для операций дробильщика 3-го уровня.");
        this.addConfig("tier4CrusherOutputMultiplier", "Коэффициент продукции для операций дробильщика 4-го уровня.");
        this.addConfig("crusherResultPickupDelay", "Задержка, прежде чем могут быть подобраны предметы из дробильщика.");
        this.addConfig("tier1SmelterTimeMultiplier", "Временной коэффициент для операций литейщика 1-го уровня.");
        this.addConfig("tier2SmelterTimeMultiplier", "Временной коэффициент для операций литейщика 2-го уровня.");
        this.addConfig("tier3SmelterTimeMultiplier", "Временной коэффициент для операций литейщика 3-го уровня.");
        this.addConfig("tier4SmelterTimeMultiplier", "Временной коэффициент для операций литейщика 4-го уровня.");
        this.addConfig("smelterResultPickupDelay", "Задержка, прежде чем могут быть подобраны предметы из литейщика.");
        this.addConfig("blacksmithFamiliarRepairChance", "Шанс Кузнецу-фамильяру починить предмет каждый такт.");
        this.addConfig("blacksmithFamiliarUpgradeCost", "Стоимость (в уровнях опыта) обновления предметов Кузнецом-фамильяром.");
        this.addConfig("blacksmithFamiliarUpgradeCooldown", "Перезарядка в тактах, прежде чем Кузнец-фамильяр снова может улучшать предметы.");
		this.addConfig("greedySearchRange", "Дальность поиска по горизонтали Алчного фамильяра обновлён");
        this.addConfig("greedyVerticalSearchRange", "Дальность поиска по вертикали Алчного фамильяра обновлён");

        this.addConfig("rituals", "Настройки ритуалов");
        this.addConfig("enableClearWeatherRitual", "Включить условия ритуалу для ясной погоды.");
        this.addConfig("enableRainWeatherRitual", "Включить условия ритуалу для вызова дождливой погоды.");
        this.addConfig("enableThunderWeatherRitual", "Включить условия ритуалу для вызова грозы.");
        this.addConfig("enableDayTimeRitual", "Позволить ритуалу изменять время на день.");
        this.addConfig("enableNightTimeRitual", "Позволить ритуалу изменять время на ночь.");
        this.addConfig("enableRemainingIngredientCountMatching", "Включить соответствия оставшихся ингредиентов в рецептах ритуала.");
        this.addConfig("ritualDurationMultiplier", "Коэффициент регулирования продолжительности всех ритуалов.");
        this.addConfig("possibleSpiritNames", "Возможные имена духов");

        this.addConfig("dimensional_mineshaft", "Настройки пространственной шахты");
        this.addConfig("miner_foliot_unspecialized", "Неспециализированный Фолиот-Рудокоп");
        this.addConfig("miner_djinni_ores", "Рудный Джинн-Рудокоп");
        this.addConfig("miner_afrit_deeps", "Африт-Рудокоп для глубинносланцевой руды");
        this.addConfig("miner_marid_master", "Мастер Марид-Рудокоп");
		this.addConfig("miner_ancient_eldritch", "Сверхъестественный древний рудокоп");

        this.addConfig("maxMiningTime", "Макс. время добычи");
        this.addConfig("rollsPerOperation", "Циклов за операцию");
        this.addConfig("durability", "Прочность");
		
		this.addConfig("items", "Предметы");
        this.addConfig("anyOreDivinationRod", "Прорицание c:ores");
		this.addConfig("minerOutputBeforeBreak", "Сохранить рудокопов до разрушения");
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
        this.lang("ru_ru").add("occultism.waila.current_ritual", "Текущий ритуал: %s");
        this.lang("ru_ru").add("occultism.waila.no_current_ritual", "Отсутствует текущий ритуал.");
        this.lang("ru_ru").add("occultism.waila.no_item_use", "Требуемый предмет не использовался.");
        this.lang("ru_ru").add("occultism.waila.no_sacrifice", "Не выполнено требуемое жертвоприношения.");
        this.lang("ru_ru").add("occultism.waila.foliot", "Фолиот");
        this.lang("ru_ru").add("occultism.waila.foliot_age", "Фолиот: осталось %s секунд.");
        this.lang("ru_ru").add("occultism.waila.djinni", "Джинн");
        this.lang("ru_ru").add("occultism.waila.djinni_age", "Джинн: осталось %s секунд.");
        this.lang("ru_ru").add("occultism.waila.afrit", "Африт");
        this.lang("ru_ru").add("occultism.waila.afrit_age", "Африт: осталось %s секунд.");
        this.lang("ru_ru").add("occultism.waila.marid", "Марид");
        this.lang("ru_ru").add("occultism.waila.marid_age", "Марид: осталось %s секунд.");
    }
}
