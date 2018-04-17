package org.openpaas.paasta.portal.web.admin.model;

import java.util.UUID;

/**
 * 쿼터 모델
 *
 * @author 조민구
 * @version 1.1
 * @since 2016.4.4 최초작성 조민구
 * 		  2018.4.11 확장   CISS
 *
 */
public class Quota extends Entity {

    private boolean nonBasicServicesAllowed = false;
    private int totalServices;
    private int totalRoutes;
    private int memoryLimit;

    private String name;
    private int instanceMemoryLimit;
    private int appInstanceLimit;
    private int totalReservedRoutePorts;
    private UUID guid;
    private String organizationName;

    public Quota() {
        //empty
    }

    public Quota(Meta meta, String name, boolean nonBasicServicesAllowed,
                 int totalServices, int totalRoutes, int memoryLimit) {
        super(meta, name);
        this.totalServices = totalServices;
        this.totalRoutes = totalRoutes;
        this.memoryLimit = memoryLimit;
        this.nonBasicServicesAllowed = nonBasicServicesAllowed;

    }

    /**
     * Default value :"app_instance_limit:-1" "instance_memory_limit:-1" "total_reserved_route_ports:0"
     *
     * @param meta
     * @param name
     */
    public Quota(Meta meta, String name) {
        super(meta, name);
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }

    public int getTotalRoutes() {
        return totalRoutes;
    }

    public void setTotalRoutes(int totalRoutes) {
        this.totalRoutes = totalRoutes;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean isNonBasicServicesAllowed() {
        return nonBasicServicesAllowed;
    }

    public void setNonBasicServicesAllowed(boolean nonBasicServicesAllowed) {
        this.nonBasicServicesAllowed = nonBasicServicesAllowed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getInstanceMemoryLimit() {
        return instanceMemoryLimit;
    }

    public void setInstanceMemoryLimit(int instanceMemoryLimit) {
        this.instanceMemoryLimit = instanceMemoryLimit;
    }

    public int getAppInstanceLimit() {
        return appInstanceLimit;
    }

    public void setAppInstanceLimit(int appInstanceLimit) {
        this.appInstanceLimit = appInstanceLimit;
    }

    public int getTotalReservedRoutePorts() {
        return totalReservedRoutePorts;
    }

    public void setTotalReservedRoutePorts(int totalReservedRoutePorts) {
        this.totalReservedRoutePorts = totalReservedRoutePorts;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


}