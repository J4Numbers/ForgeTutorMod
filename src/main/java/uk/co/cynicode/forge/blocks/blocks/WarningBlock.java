package uk.co.cynicode.forge.blocks.blocks;
/**
 * Copyright 2015 J4Numbers (j4numbers@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import uk.co.cynicode.forge.ForgeTutorMod;
import uk.co.cynicode.forge.blocks.Controller;
import uk.co.cynicode.forge.blocks.tile_entities.TileEntityWarning;

/**
 * Class Name - WarningBlock
 * Package - uk.co.cynicode.forge.blocks.blocks
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 10/01/2015
 */
public class WarningBlock extends Block implements ITileEntityProvider {

	public WarningBlock(Material mat, String base, String mod) {
		super(mat);
		super.setBlockTextureName(String.format(
				"%s_%s", base, mod
		));
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityWarning();
		// te;
	}

	@Override
	public boolean onBlockActivated(
			World w, int i1, int i2, int i3, EntityPlayer p, int i4,
			float f1, float f2, float f3) {
		if (!w.isRemote) {
			TileEntityWarning t = (TileEntityWarning) w.getTileEntity( i1, i2, i3 );
			t.toggleActivation();

			ForgeTutorMod.getLogger().info("Current state of warning: "+ t.warning);

			w.setBlock(i1,i2,i3, (t.warning) ?
					Controller.warningBlockRed :
					Controller.warningBlockGreen);
		}

		return true;
	}

}
