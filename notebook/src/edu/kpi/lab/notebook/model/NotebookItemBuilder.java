package edu.kpi.lab.notebook.model;

public class NotebookItemBuilder {
	private final NotebookItem item;
	public NotebookItemBuilder() {
		this.item = new NotebookItem("", "", "", "", "", "");
	}

	public NotebookItemBuilder(NotebookItem item) {
		this.item = item;
	}

	public void setSurname(String surname) {
		item.setSurname(surname);
	}

	public void setName(String name) {
		item.setName(name);
	}

	public void setMiddleName(String middleName) {
		item.setMiddleName(middleName);
	}

	public void setAddress(String address) {
		item.setAddress(address);
	}

	public void setTelephone(String telephone) {
		item.setTelephone(telephone);
	}

	public void setAdditionalInfo(String additionalInfo) {
		item.setAdditionalInfo(additionalInfo);
	}

	public NotebookItem getNotebookItem() {
		return this.item;
	}
}
