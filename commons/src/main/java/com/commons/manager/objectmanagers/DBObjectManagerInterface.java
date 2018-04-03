package com.commons.manager.objectmanagers;

import org.hibernate.SessionFactory;

public interface DBObjectManagerInterface {
	public SessionFactory getMasterDBFactory();
}
