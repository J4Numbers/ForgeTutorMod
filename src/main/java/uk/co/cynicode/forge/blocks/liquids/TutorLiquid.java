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

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import uk.co.cynicode.forge.reference.Reference;

/**
 * Class Name - TutorLiquid
 * Package - uk.co.cynicode.forge.blocks
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 22/12/2014
 */
public abstract class TutorLiquid extends BlockFluidClassic {

	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;

	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	public TutorLiquid(Fluid fluid, Material mat) {
		super(fluid, mat);
		this.setCreativeTab(CreativeTabs.tabBlock);
		fluid.setUnlocalizedName(this.getUnlocalizedName());
	}

	public TutorLiquid(Fluid f) {
		this(f, Material.water);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format(
				"fluid.%s:%s", Reference.MOD_ID.toLowerCase(),
				super.fluidName
		);
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1)? stillIcon : flowingIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(String.format(
				"%s_still",
				getUnwrappedUnlocalizedName(this.getUnlocalizedName())
		));
		flowingIcon = register.registerIcon(String.format(
				"%s_flow",
				getUnwrappedUnlocalizedName(this.getUnlocalizedName())
		));
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}

}
