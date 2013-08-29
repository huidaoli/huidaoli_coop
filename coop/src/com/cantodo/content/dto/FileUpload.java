package com.cantodo.content.dto;

import java.io.File;

public class FileUpload
{

    
    private String controlName;
    
    private File[] uploadFiles;

    private String[] fileNames;
    
    private String contcode;

    public String getContcode() {
		return contcode;
	}

	public void setContcode(String contcode) {
		this.contcode = contcode;
	}

	public File[] getUploadFiles()
    {
        return uploadFiles;
    }

    public void setUploadFiles(File[] uploadFiles)
    {
        this.uploadFiles = uploadFiles;
    }

    public String[] getFileNames()
    {
        return fileNames;
    }

    public void setFileNames(String[] fileNames)
    {
        this.fileNames = fileNames;
    }

    public String getControlName()
    {
        return controlName;
    }

    public void setControlName(String controlName)
    {
        this.controlName = controlName;
    }

}
