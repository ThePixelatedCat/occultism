/*
 * MIT License
 *
 * Copyright 2020 klikli-dev
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

package com.klikli_dev.occultism.registry;

import com.klikli_dev.occultism.Occultism;
import com.klikli_dev.occultism.common.ritual.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class OccultismRituals {

    public static final ResourceKey<Registry<RitualFactory>> RITUAL_FACTORIES_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Occultism.MODID, "ritual_factories"));

    public static final DeferredRegister<RitualFactory> RITUAL_FACTORIES = DeferredRegister.create(RITUAL_FACTORIES_KEY, Occultism.MODID);

    public static final Registry<RitualFactory> REGISTRY = RITUAL_FACTORIES.makeRegistry((builder) -> {
    });

    //Summoning
    public static final Supplier<RitualFactory> SUMMON_RITUAL =
            RITUAL_FACTORIES.register("summon",
                    () -> new RitualFactory((r) -> new SummonRitual(r, false)));
    public static final Supplier<RitualFactory> SUMMON_TAMED_RITUAL =
            RITUAL_FACTORIES.register("summon_tamed",
                    () -> new RitualFactory((r) -> new SummonRitual(r, true)));
    public static final Supplier<RitualFactory> SUMMON_WITH_CHANCE_OF_CHICKEN_RITUAL =
            RITUAL_FACTORIES.register("summon_with_chance_of_chicken",
                    () -> new RitualFactory((r) -> new SummonWithChanceOfChickenRitual(r, false)));
    public static final Supplier<RitualFactory> SUMMON_WITH_CHANCE_OF_CHICKEN_TAMED_RITUAL =
            RITUAL_FACTORIES.register("summon_with_chance_of_chicken_tamed",
                    () -> new RitualFactory((r) -> new SummonWithChanceOfChickenRitual(r, false)));
    public static final Supplier<RitualFactory> SUMMON_SPIRIT_WITH_JOB_RITUAL =
            RITUAL_FACTORIES.register("summon_spirit_with_job",
                    () -> new RitualFactory(SummonSpiritWithJobRitual::new));
    public static final Supplier<RitualFactory> SUMMON_WILD_HUNT =
            RITUAL_FACTORIES.register("summon_wild_hunt",
                    () -> new RitualFactory(SummonWildHuntRitual::new));
    public static final DeferredHolder<RitualFactory, RitualFactory> FAMILIAR_RITUAL =
            RITUAL_FACTORIES.register("familiar",
                    () -> new RitualFactory(FamiliarRitual::new));

    public static final DeferredHolder<RitualFactory, RitualFactory> RESURRECT_FAMILIAR_RITUAL =
            RITUAL_FACTORIES.register("resurrect_familiar",
                    () -> new RitualFactory(ResurrectFamiliarRitual::new));

    //Crafting
    public static final Supplier<RitualFactory> CRAFT_RITUAL =
            RITUAL_FACTORIES.register("craft",
                    () -> new RitualFactory(CraftRitual::new));
    public static final Supplier<RitualFactory> CRAFT_WITH_SPIRIT_NAME_RITUAL =
            RITUAL_FACTORIES.register("craft_with_spirit_name",
                    () -> new RitualFactory(CraftWithSpiritNameRitual::new));
    public static final Supplier<RitualFactory> CRAFT_MINER_SPIRIT_RITUAL =
            RITUAL_FACTORIES.register("craft_miner_spirit",
                    () -> new RitualFactory(CraftMinerSpiritRitual::new));

    //Other
    public static final Supplier<RitualFactory> COMMAND_RITUAL =
            RITUAL_FACTORIES.register("execute_command",
                    () -> new RitualFactory(CommandRitual::new));
}
