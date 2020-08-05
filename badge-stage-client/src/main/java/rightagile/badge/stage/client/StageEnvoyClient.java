/*     */ package rightagile.badge.stage.client;
/*     */ 
/*     */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.accent.shared.domain.cineroom.RoleBaseRequest;
import rightagile.badge.stage.rom.cineroom.StageDramaAssignment;

import java.util.List;

/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ 
/*     */ @Component
/*     */ public class StageEnvoyClient
/*     */   implements EnvoyStageClient
/*     */ {
/*     */   private final WebClient webClient;
/*     */   
/*     */   public StageEnvoyClient(@Qualifier("stageEnvoyWebClient") WebClient webClient) {
/*  22 */     this.webClient = webClient;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AudienceSdo> findAudiences(CineroomBaseRequest cineroomBaseRequest) {
/*  28 */     StringBuilder uriStringBuilder = new StringBuilder("/audiences");
/*  29 */     uriStringBuilder.append("?cineroomId=");
/*  30 */     uriStringBuilder.append(cineroomBaseRequest.getCineroomId());
/*     */     
/*  32 */     uriStringBuilder.append("&offset.limit=");
/*  33 */     uriStringBuilder.append(cineroomBaseRequest.getOffset().getLimit());
/*  34 */     uriStringBuilder.append("&offset.offset=");
/*  35 */     uriStringBuilder.append(cineroomBaseRequest.getOffset().getOffset());
/*     */     
/*  37 */     if (cineroomBaseRequest.getAttributeNames() != null) {
/*  38 */       for (String attributeName : cineroomBaseRequest.getAttributeNames()) {
/*  39 */         uriStringBuilder.append("&attributeNames=");
/*  40 */         uriStringBuilder.append(attributeName);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     Flux<AudienceSdo> flux = this.webClient.get().uri(uriStringBuilder.toString(), new Object[0]).retrieve().bodyToFlux(AudienceSdo.class);
/*     */     
/*  50 */     return (List<AudienceSdo>)flux.collectList().block();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countAudiences(String cineroomId) {
/*  71 */     StringBuilder uriStringBuilder = new StringBuilder("/audiences/count");
/*  72 */     uriStringBuilder.append("?cineroomId=");
/*  73 */     uriStringBuilder.append(cineroomId);
/*     */     
/*  75 */     return ((Integer)this.webClient
/*  76 */       .get()
/*  77 */       .uri(uriStringBuilder.toString(), new Object[0])
/*  78 */       .retrieve()
/*  79 */       .bodyToMono(Integer.class)
/*  80 */       .block()).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AudienceSdo> findAudiencesByRoleKey(RoleBaseRequest roleBaseRequest) {
/*  86 */     StringBuilder uriStringBuilder = new StringBuilder("/audiences/byRoleKey");
/*  87 */     uriStringBuilder.append("?cineroomId=");
/*  88 */     uriStringBuilder.append(roleBaseRequest.getCineroomId());
/*     */     
/*  90 */     uriStringBuilder.append("&roleKey=");
/*  91 */     uriStringBuilder.append(roleBaseRequest.getRoleKey());
/*     */     
/*  93 */     uriStringBuilder.append("&offset.limit=");
/*  94 */     uriStringBuilder.append(roleBaseRequest.getOffset().getLimit());
/*  95 */     uriStringBuilder.append("&offset.offset=");
/*  96 */     uriStringBuilder.append(roleBaseRequest.getOffset().getOffset());
/*     */     
/*  98 */     if (roleBaseRequest.getAttributeNames() != null) {
/*  99 */       for (String attributeName : roleBaseRequest.getAttributeNames()) {
/* 100 */         uriStringBuilder.append("&attributeNames=");
/* 101 */         uriStringBuilder.append(attributeName);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     Flux<AudienceSdo> flux = this.webClient.get().uri(uriStringBuilder.toString(), new Object[0]).retrieve().bodyToFlux(AudienceSdo.class);
/*     */     
/* 111 */     return (List<AudienceSdo>)flux.collectList().block();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StageDramaAssignment findDramaAssignment(String cineroomId, String dramaId) {
/* 117 */     StringBuilder uriStringBuilder = new StringBuilder("/cinerooms/dramaAssignment");
/* 118 */     uriStringBuilder.append("?cineroomId=");
/* 119 */     uriStringBuilder.append(cineroomId);
/*     */     
/* 121 */     uriStringBuilder.append("&dramaId=");
/* 122 */     uriStringBuilder.append(dramaId);
/*     */     
/* 124 */     return (StageDramaAssignment)this.webClient
/* 125 */       .get()
/* 126 */       .uri(uriStringBuilder.toString(), new Object[0])
/* 127 */       .retrieve()
/* 128 */       .bodyToMono(StageDramaAssignment.class)
/* 129 */       .block();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DramaRoleMap findDramaRoleMap(String cineroomId, String dramaId) {
/* 135 */     StringBuilder uriStringBuilder = new StringBuilder("/cinerooms/dramaRoleMap");
/* 136 */     uriStringBuilder.append("?cineroomId=");
/* 137 */     uriStringBuilder.append(cineroomId);
/*     */     
/* 139 */     uriStringBuilder.append("&dramaId=");
/* 140 */     uriStringBuilder.append(dramaId);
/*     */     
/* 142 */     return (DramaRoleMap)this.webClient
/* 143 */       .get()
/* 144 */       .uri(uriStringBuilder.toString(), new Object[0])
/* 145 */       .retrieve()
/* 146 */       .bodyToMono(DramaRoleMap.class)
/* 147 */       .block();
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-client-0.5.0-20191216.092137-2.jar!/io/naraplatform/stage/client/StageEnvoyClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */