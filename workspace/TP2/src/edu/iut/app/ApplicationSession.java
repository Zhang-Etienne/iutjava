package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession{
	
	// Exercice 1 : Gérer l'internationation
	protected ResourceBundle resourceBundle; /* Objet permettant la gestion des 'resources bundle' */ 
	protected Locale locale; /* Objet permettant la gestion des Locales */
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	private static ApplicationSession session = null;
	/*Qu'est ce qu'un singleton ?
	 * c'est un designe pattern
	 * 1.garantir qu'une unique instance d'une classe donné sera créée
	 * 2.offrir un point d'accès universel à cette instance.
	 */
	private ApplicationSession() {
		/* Definir US comme locale par défaut */
		Locale.setDefault(Locale.US);//我们使用java.lang.Locale来构造Java国际化的情境。
		
		locale = Locale.getDefault();//获得此Java虚拟机当前线程默认的语言环境值
		
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.ref", locale);
		/*
		 * 这个类的作用就是读取资源属性文件（properties）
		 * 然后根据.properties文件的名称信息（本地化信息）
		 * 匹配当前系统的国别语言信息（也可以程序指定）
		 * 然后获取相应的properties文件的内容。
		 */
		sessionGuiLogger = Logger.getLogger("Logger"); //getLogger()获得已为此 Logger 指定的日志级别（Level）
		/* Touls les message doivent être affiché : */
		sessionGuiLogger.setLevel(Level.ALL); //setLevel()设置日志级别，指定此 logger 记录的消息级别。
		/* Logger pour exception : */
		sessionExceptionLogger = Logger.getLogger("LoggerException");
		/* Touls les message doivent être affiché */
		sessionExceptionLogger.setLevel(Level.ALL);
	}
	
	
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		/* récupérer les resources : */
		resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.ref", locale);
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
