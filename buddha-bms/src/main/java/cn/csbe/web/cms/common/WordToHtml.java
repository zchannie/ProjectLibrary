package cn.csbe.web.cms.common;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordToHtml
{
	// ------------------------------------------------------------------------------
	// 方法原型: change(String paths)
	// 功能描述: 将指定目录下面所有的doc文件转化为HTML并存储在相同目录下
	// 输入参数: String
	// 输出参数: 无
	// 返 回 值: 无
	// 其它说明: 递归
	// ------------------------------------------------------------------------------
	public static boolean change(String FolderPath, String FileName,String outFolder,ActiveXComponent app)
	{

		String FileFormat = "";
		System.out.println(FolderPath);
		int fileSuffix = 4;
		if(FileName.endsWith("docx"))
		{
			FileFormat = FileName.substring(FileName.length() - 5,
					FileName.length());
			fileSuffix = 5;
		}
		else
		{
			FileFormat = FileName.substring(FileName.length() - 4,
					FileName.length());
		}
		
		System.out.println(FileFormat);

		if (FileFormat.equalsIgnoreCase(".doc")
				|| FileFormat.equalsIgnoreCase(".docx"))
		{
			
			String DocFile = FolderPath + "//" + FileName;
			String htmlFile = outFolder + "//" + FileName;

			System.out.println("word文件路径：" + DocFile);
			// word文件的完整路径

			String HtmlFile = htmlFile.substring(0,
					(htmlFile.length() - fileSuffix)) + ".html";

			System.out.println("htm文件路径：" + HtmlFile);
			// html文件的完整路径
			System.out.println(System.getProperty("java.library.path"));
			// 启动word

			try
			{
				app.setProperty("Visible", new Variant(false));
				// 设置word程序非可视化运行

				Dispatch docs = app.getProperty("Documents").toDispatch();

				Dispatch doc = Dispatch.invoke(
						docs,
						"Open",
						Dispatch.Method,
						new Object[] { DocFile, new Variant(false),
								new Variant(true) }, new int[1]).toDispatch();
				// 打开word文件

				Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
						HtmlFile, new Variant(8) }, new int[1]);
				// 作为htm格式保存文件

				Dispatch.call(doc, "Close", new Variant(false));
				// 关闭文件

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			// 转化完毕
			return true;
		}
		return false;
	}

	// ------------------------------------------------------------------------------
	// 方法原型: main(String[] args)
	// 功能描述: main文件
	// 输入参数: 无
	// 输出参数: 无
	// 返 回 值: 无
	// 其它说明: 无
	// ------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		String paths = new String("H:\\高僧大德（文案）\\高僧");
		String pathsOut = new String("D:\\companyInfo\\APP页面\\高僧大德文章");
//		String filename = "垂范德萨发2011.docx";
		File docFiles = new File(paths);
		String[] names = docFiles.list();
		for (int i = 0; i < names.length; i++)
		{
			System.out.println(names[i]);
			if(!names[i].startsWith("~"))
			{
				change(paths, names[i],pathsOut, app);
			}
		}
		app.invoke("Quit", new Variant[] {});
	}
}

