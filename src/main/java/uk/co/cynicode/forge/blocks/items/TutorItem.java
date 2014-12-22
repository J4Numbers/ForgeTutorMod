package uk.co.cynicode.forge.blocks.items;
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

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import uk.co.cynicode.forge.reference.Names;
import uk.co.cynicode.forge.reference.Reference;

/**
 * Class Name - TutorItem
 * Package - uk.co.cynicode.forge.blocks.items
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 22/12/2014
 */
public abstract class TutorItem extends Item {

	public TutorItem(String item) {
		super();
		setUnlocalizedName(
				String.format("forgetutormod:%s",item)
		);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format(
				"item.%s:%s", Reference.MOD_ID.toLowerCase(),
				Names.Blocks.TARBALL
		);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(
				String.format(
						"%s",
						getUnwrappedUnlocalizedName(this.getUnlocalizedName())
				)
		);
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
