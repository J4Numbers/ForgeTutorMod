package uk.co.cynicode.forge.blocks.liquids;
/**
 * Copyright 2014 J4Numbers (j4numbers@gmail.com)
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Class Name - TutorLiquid
 * Package - uk.co.cynicode.forge.blocks
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 22/12/2014
 */
public class TutorLiquid extends BlockFluidClassic {

	String txtureName;

	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;

	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	public TutorLiquid(Fluid fluid, Material mat) {
		super(fluid, mat);
	}

	public TutorLiquid(Fluid f) {
		this(f, Material.water);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1)? stillIcon : flowingIcon;
	}

	@Override
	public Block setBlockTextureName(String s) {
		super.setBlockTextureName(s);
		this.txtureName = s;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(String.format(
				"%s_still",
				this.txtureName
		));
		flowingIcon = register.registerIcon(String.format(
				"%s_flow",
				this.txtureName
		));
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		return (!world.getBlock(x, y, z).getMaterial().isLiquid()) &&
				super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		return !world.getBlock(x, y, z).getMaterial().isLiquid() &&
				super.displaceIfPossible(world, x, y, z);
	}

}
