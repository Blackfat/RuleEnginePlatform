package com.blackfat.rule.engine.core.util;

import com.blackfat.rule.engine.core.exception.EngineRuntimeException;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-06 15:19
 * @since 1.0-SNAPSHOT
 */
public class DroolsRuleBuilder {

	private static final String GROUP_IP = "com.blackfat.rule";

	private static final String ARTIFACT_ID_PREFIX = "rule_";

	private static final String RELEASE_ID = "1.0.0";

	private static KieServices kieServices = KieServices.Factory.get();

	public static KieContainer loadRule(String ruleId, String ruleDrl) {
		ReleaseId releaseId = kieServices.newReleaseId(GROUP_IP, ARTIFACT_ID_PREFIX + ruleId, RELEASE_ID);
		KieFileSystem fileSystem = kieServices.newKieFileSystem();
		fileSystem.generateAndWritePomXML(releaseId);
		fileSystem.write(String.format("src/main/resources/rules/%s.drl", ruleId), ruleDrl);

		KieBuilder kb = kieServices.newKieBuilder(fileSystem);
		kb.buildAll();
		if (kb.getResults().hasMessages(Level.ERROR)) {
			throw new EngineRuntimeException("Build Errors:\n" + kb.getResults().toString());
		}

		return kieServices.newKieContainer(releaseId);
	}
}
