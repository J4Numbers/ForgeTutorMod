package uk.co.cynicode.forge.blocks;
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

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import uk.co.cynicode.forge.blocks.blocks.TutorBlock;
import uk.co.cynicode.forge.blocks.items.TutorBucket;
import uk.co.cynicode.forge.blocks.items.TutorItem;
import uk.co.cynicode.forge.blocks.liquids.TutorLiquid;
import uk.co.cynicode.forge.blocks.tabs.TutorTab;
import uk.co.cynicode.forge.generation.BlockGeneration;
import uk.co.cynicode.forge.reference.Names;
import uk.co.cynicode.forge.reference.Reference;

/**
 * Class Name - Controller
 * Package - uk.co.cynicode.forge.blocks
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 22/12/2014
 */
public class Controller {

	public static CreativeTabs tutorTab;

	public static Block tarmacBlock;
	public static Fluid tarFluid;
	public static Block tarLiquid;
	public static Item tarballItem;
	public static Item tarBucket;

	public static void creation() {
		tutorTab = new TutorTab(Reference.MOD_ID.toLowerCase());
		tarFluid = new Fluid(Names.Blocks.TAR);

		tarmacBlock = new TutorBlock(Material.rock).setBlockName(Names.Blocks.TARMAC)
				.setBlockTextureName(
						String.format("%s:%s", Reference.MOD_ID, Names.Blocks.TARMAC)
				)
				.setCreativeTab(tutorTab);
		tarballItem = new TutorItem(Names.Blocks.TARBUCKET).setUnlocalizedName(Names.Blocks.TARBALL)
					.setCreativeTab(tutorTab).setTextureName(
						String.format("%s:%s", Reference.MOD_ID, Names.Blocks.TARBALL)
				);

		tarFluid.setViscosity(7500).setDensity(1500);
		GameRegistry.registerBlock(tarmacBlock, Names.Blocks.TARMAC);
		FluidRegistry.registerFluid(tarFluid);
		tarLiquid = new TutorLiquid(tarFluid).setBlockName(Names.Blocks.TAR)
				.setBlockTextureName(String.format(
						"%s:%s", Reference.MOD_ID, Names.Blocks.TAR
				)).setCreativeTab(tutorTab);
		tarBucket = new TutorBucket(tarLiquid).setUnlocalizedName(Names.Blocks.TARBUCKET)
				.setCreativeTab(tutorTab)
				.setTextureName( String.format(
						"%s:%s", Reference.MOD_ID, Names.Blocks.TARBUCKET
				));
		tarFluid.setBlock(tarLiquid);

		GameRegistry.registerBlock(tarLiquid, tarFluid.getUnlocalizedName());
		GameRegistry.registerItem(tarballItem, Names.Blocks.TARBALL);
		GameRegistry.registerItem(tarBucket, Names.Blocks.TARBUCKET);
		FluidContainerRegistry.registerFluidContainer(
				FluidRegistry.getFluidStack(Names.Blocks.TAR, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(tarBucket), new ItemStack(Items.bucket)
		);

		GameRegistry.addSmelting(Blocks.stone, new ItemStack(tarballItem), 10);
		GameRegistry.registerWorldGenerator(new BlockGeneration(), 13);
		GameRegistry.addRecipe(
				new ItemStack(tarmacBlock), "xxx", "xyx", "xxx",
				'x', new ItemStack(Blocks.stone), 'y', new ItemStack(Items.lava_bucket)
		);
		GameRegistry.addRecipe(
				new ItemStack(tarBucket), " x ", "xyx", " x ",
				'x', new ItemStack(tarballItem), 'y', new ItemStack(Items.bucket)
		);
	}

}
