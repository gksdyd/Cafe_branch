package cafe_project.app;

import java.io.IOException;

import cafe_project.api.ArrayListApi;
import cafe_project.api.FileApi;

public class FileInOutput {

	FileApi fileApi;
	
	public FileInOutput() throws IOException {
		fileApi = new FileApi();
	}
	
	public FileInOutput(String list, int rw) throws IOException {
		fileApi = new FileApi(list, rw);
	}
	
	public String[] readFileNames() {
		return fileApi.getFileNames();
	}
}
