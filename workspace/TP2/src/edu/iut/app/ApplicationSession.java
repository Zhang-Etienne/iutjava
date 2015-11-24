package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession{
	
	// Exercice 1 : G��rer l'internationation
	protected ResourceBundle resourceBundle; /* Objet permettant la gestion des 'resources bundle' */ 
	protected Locale locale; /* Objet permettant la gestion des Locales */
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	private static ApplicationSession session = null;
	/*Qu'est ce qu'un singleton ?
	 * c'est un designe pattern
	 * 1.garantir qu'une unique instance d'une classe donn�� sera cr����e
	 * 2.offrir un point d'acc��s universel �� cette instance.
	 */
	private ApplicationSession() {
		/* Definir US comme locale par d��faut */
		Locale.setDefault(Locale.US);//����ʹ��java.lang.Locale������Java���ʻ����龳��
		
		locale = Locale.getDefault();//��ô�Java�������ǰ�߳�Ĭ�ϵ����Ի���ֵ
		
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.ref", locale);
		/*
		 * ���������þ��Ƕ�ȡ��Դ�����ļ���properties��
		 * Ȼ�����.properties�ļ���������Ϣ�����ػ���Ϣ��
		 * ƥ�䵱ǰϵͳ�Ĺ���������Ϣ��Ҳ���Գ���ָ����
		 * Ȼ���ȡ��Ӧ��properties�ļ������ݡ�
		 */
		sessionGuiLogger = Logger.getLogger("Logger"); //getLogger()�����Ϊ�� Logger ָ������־����Level��
		/* Touls les message doivent ��tre affich�� : */
		sessionGuiLogger.setLevel(Level.ALL); //setLevel()������־����ָ���� logger ��¼����Ϣ����
		/* Logger pour exception : */
		sessionExceptionLogger = Logger.getLogger("LoggerException");
		/* Touls les message doivent ��tre affich�� */
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
		/* r��cup��rer les resources : */
		resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.ref", locale);
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
