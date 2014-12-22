package uk.co.cynicode.forge.blocks.fluids;
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

import net.minecraftforge.fluids.Fluid;
import uk.co.cynicode.forge.reference.Reference;

/**
 * Class Name - TarFluid
 * Package - uk.co.cynicode.forge.blocks.fluids
 * Desc of Class - ...
 * Author(s) - J4Numbers
 * Last Mod: 22/12/2014
 */
public class TarFluid extends Fluid {

	public TarFluid(String fluidName) {
		super(fluidName);
		this.setViscosity(7500);
		this.setDensity(1500);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format(
				"fluid.%s:%s", Reference.MOD_ID.toLowerCase(),
				super.fluidName
		);
	}

}
