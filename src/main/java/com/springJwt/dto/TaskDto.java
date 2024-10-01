package com.springJwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto {

    @NotNull(message = "Title Is Mandatory")
    @NotBlank(message = "Title Is Mandatory" )
    private String title;

    @NotNull(message = "description Is Mandatory")
    @NotBlank(message = "description Is Mandatory" )
    private String description;

    @NotNull(message = "status Is Mandatory")
    @NotBlank(message = "status Is Mandatory" )
    private String status;

    public @NotNull(message = "Title Is Mandatory") @NotBlank(message = "Title Is Mandatory") String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "Title Is Mandatory") @NotBlank(message = "Title Is Mandatory") String title) {
        this.title = title;
    }

    public @NotNull(message = "description Is Mandatory") @NotBlank(message = "description Is Mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "description Is Mandatory") @NotBlank(message = "description Is Mandatory") String description) {
        this.description = description;
    }

    public @NotNull(message = "status Is Mandatory") @NotBlank(message = "status Is Mandatory") String getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "status Is Mandatory") @NotBlank(message = "status Is Mandatory") String status) {
        this.status = status;
    }
}
