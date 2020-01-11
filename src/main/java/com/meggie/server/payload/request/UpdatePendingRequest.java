package com.meggie.server.payload.request;

import javax.validation.constraints.NotNull;

public class UpdatePendingRequest {
    @NotNull
    private Long id;

    @NotNull
    private boolean isPending;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsPending() {
        return this.isPending;
    }

    public boolean getIsPending() {
        return this.isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }
}