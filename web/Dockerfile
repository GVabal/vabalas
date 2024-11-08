FROM node:20.18.0-alpine3.20 as build
WORKDIR /app
COPY package.json ./
RUN npm config set package-lock false
RUN npm i
COPY . .
RUN npm run build

FROM node:20.18.0-alpine3.20
RUN addgroup -S websiteusergroup && adduser -S websiteserviceaccount -G websiteusergroup
USER websiteserviceaccount
WORKDIR /usr/app
COPY --from=build /app/src/dist/web/ ./
CMD node server/server.mjs
