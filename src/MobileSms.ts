// src/MobileSms.ts

import type { TurboModule } from "react-native";
import { TurboModuleRegistry } from "react-native";

// TypeScript interface — no `+` allowed like in Flow
export interface Spec extends TurboModule {
  sendSms(phoneNumber: string, message: string): void;
}

// This will be used by Codegen to generate native bindings
export default TurboModuleRegistry.getEnforcing<Spec>("MobileSms");
