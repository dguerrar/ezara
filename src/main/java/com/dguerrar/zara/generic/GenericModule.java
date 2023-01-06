package com.dguerrar.zara.generic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericModule {
    protected Logger log = LoggerFactory.getLogger(getLogClass());
    protected abstract Class<?> getLogClass();
}
