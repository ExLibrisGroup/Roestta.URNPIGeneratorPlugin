package com.exlibris.dps.repository.plugin.pi;

import com.exlibris.core.sdk.repository.TaskResults;
import com.exlibris.digitool.common.pi.URN;
import com.exlibris.dps.sdk.plugin.PIGeneratorPlugin;

public class URNPIGeneratorPlugin implements PIGeneratorPlugin {

	@Override
	public TaskResults getValue(String piValue, String prefix, String controlPid, TaskResults result) {
		String urn = piValue.replace(prefix, "");
		// add additional value to pi and return it
		result.setAdditionalData(prefix + urn + URN.getCheckDigit(urn));
		return result;
	}
}