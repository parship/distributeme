package org.distributeme.generator;

import net.anotheria.util.StringUtils;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/**
 * Generates constants class for rmi service distribution.
 *
 * @author lrosenberg.
 * @version $Id: $Id
 */
public class ConstantsGenerator extends AbstractGenerator implements Generator{

	/**
	 * <p>Constructor for ConstantsGenerator.</p>
	 *
	 * @param environment a {@link javax.annotation.processing.ProcessingEnvironment} object.
	 */
	public ConstantsGenerator(ProcessingEnvironment environment) {
		super(environment);
	}

	/** {@inheritDoc} */
	@Override
	public void generate(TypeElement type, Filer filer, Map<String,String> options) throws IOException{
		JavaFileObject sourceFile = filer.createSourceFile(getPackageName(type)+"."+getConstantsName(type));
        PrintWriter writer = new PrintWriter(sourceFile.openWriter());
		setWriter(writer);
		
		
		writePackage(type);
		writeAnalyzerComments(type);
		emptyline();
		
		writeString("public class "+getConstantsName(type)+"{");
		increaseIdent();
		emptyline();

		writeString("public static final String getServiceId(){");
		increaseIdent();
		writeStatement("return "+quote(StringUtils.replace(type.getQualifiedName().toString(), '.', '_')));
		
		//writeStatement("this(new "+type.getAnnotation(DistributeMe.class).implName()+"())");
		closeBlock("getServiceId");
		
		closeBlock();
		
		
		writer.flush();
		writer.close();
	}
}
