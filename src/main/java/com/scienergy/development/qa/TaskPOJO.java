package com.scienergy.development.qa;

import java.lang.reflect.Method;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TaskPOJO {

	private String summary;
	private String description;
	private String location;
	private int locationPresent;
	private String dueDate;
	private String[] labels;
	private int labelsPresent;
	private String assignee;
	private int assigneePresent;
	private String comment001;
	private String comment002;
	private int status;
	private int blocked;
	private int canceled;
	private Boolean open;

	public TaskPOJO() {

	}


	public int getLabelsPresent() {
		return labelsPresent;
	}


	public void setLabelsPresent(int labelsPresent) {
		this.labelsPresent = labelsPresent;
	}


	public int getBlocked() {
		return blocked;
	}


	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}


	public int getCanceled() {
		return canceled;
	}


	public void setCanceled(int canceled) {
		this.canceled = canceled;
	}


	public int getLocationPresent() {
		return locationPresent;
	}


	public void setLocationPresent(int locationPresent) {
		this.locationPresent = locationPresent;
	}


	public int getAssigneePresent() {
		return assigneePresent;
	}


	public void setAssigneePresent(int assigneePresent) {
		this.assigneePresent = assigneePresent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getComment001() {
		return comment001;
	}

	public void setComment001(String comment001) {
		this.comment001 = comment001;
	}

	public String getComment002() {
		return comment002;
	}

	public void setComment002(String comment002) {
		this.comment002 = comment002;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TaskPOJO) {
			TaskPOJO other = (TaskPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.summary, other.summary);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		 builder.append(summary);
		 builder.append(description);
		 builder.append(dueDate);
		 builder.append(labelsPresent);
		 builder.append(assigneePresent);
		 builder.append(locationPresent);
		 builder.append(blocked);
		 builder.append(canceled);
		return builder.toHashCode();
	}

}
