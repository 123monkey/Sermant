/*
 * Copyright (C) 2021-2022 Huawei Technologies Co., Ltd. All rights reserved.
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

package com.huaweicloud.sermant.core.plugin.agent.declarer;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.JavaModule;

import java.security.ProtectionDomain;

/**
 * 抽象的插件描述器，简化类的匹配方法，仅使用类的描述器匹配
 * AbstractPluginDescription, simplifies the matching method of the class, only using the class description matching
 *
 * @author HapThorin
 * @version 1.0.0
 * @since 2022-01-25
 */
public abstract class AbstractPluginDescription implements ElementMatcher<TypeDescription>, PluginDescription {
    @Override
    public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module,
            Class<?> classBeingRedefined, ProtectionDomain protectionDomain) {
        return matches(typeDescription);
    }
}
