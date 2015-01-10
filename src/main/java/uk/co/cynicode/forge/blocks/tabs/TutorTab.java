package uk.co.cynicode.forge.blocks.tabs;
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

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import uk.co.cynicode.forge.reference.Names;
import uk.co.cynicode.forge.reference.Reference;

/**
 * Class Name - TutorTab
 * Package - uk.co.cynicode.forge.blocks.tabs
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 10/01/2015
 */
public class TutorTab extends CreativeTabs {

	public TutorTab(String name) {
		super(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return GameRegistry.findItem(
				Reference.MOD_ID, Names.Blocks.TARBALL
		);
	}

}
