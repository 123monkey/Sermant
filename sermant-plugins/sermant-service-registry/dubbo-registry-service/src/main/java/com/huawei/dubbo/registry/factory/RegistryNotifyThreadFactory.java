/*
 * Copyright (C) 2022-2022 Huawei Technologies Co., Ltd. All rights reserved.
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

package com.huawei.dubbo.registry.factory;

import java.util.concurrent.ThreadFactory;

/**
 * Create a registered listener thread factory class
 *
 * @author chengyouling
 * @since 2022-11-27
 */
public class RegistryNotifyThreadFactory implements ThreadFactory {
    private final String threadName;

    /**
     * Flow-throttling thread factory
     *
     * @param threadName The name of the thread
     */
    public RegistryNotifyThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, threadName);
    }
}
