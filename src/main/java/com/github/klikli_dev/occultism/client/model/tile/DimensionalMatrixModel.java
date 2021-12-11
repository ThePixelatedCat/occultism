/*
 * MIT License
 *
 * Copyright 2021 klikli-dev
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

package com.github.klikli_dev.occultism.client.model.tile;

import com.github.klikli_dev.occultism.Occultism;
import com.github.klikli_dev.occultism.common.tile.StorageControllerTileEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DimensionalMatrixModel extends AnimatedGeoModel<StorageControllerTileEntity> {
    @Override
    public ResourceLocation getModelLocation(StorageControllerTileEntity object) {
        return new ResourceLocation(Occultism.MODID, "geo/dimensional_matrix.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(StorageControllerTileEntity object) {
        return new ResourceLocation(Occultism.MODID, "textures/block/dimensional_matrix.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(StorageControllerTileEntity animatable) {
        return new ResourceLocation(Occultism.MODID, "animations/dimensional_matrix.animation.json");
    }
}
